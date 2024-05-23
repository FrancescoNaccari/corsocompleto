package nextDevs.esercizio.service;


import com.cloudinary.Cloudinary;
import nextDevs.esercizio.dto.AutoreDto;
import nextDevs.esercizio.exception.AutoreNonTrovatoException;
import nextDevs.esercizio.exception.BlogPostNonTrovatoException;
import nextDevs.esercizio.model.Autore;
import nextDevs.esercizio.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;


@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;
    @Autowired
    private Cloudinary cloudinary ;
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public String saveAutore(AutoreDto autoreDto) {
        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setEmail(autoreDto.getEmail());
        autore.setDataDiNascita(autoreDto.getDataDiNascita());
        autore.setAvatar("https://ui-avatars.com/api/?name="+autoreDto.getNome()+"+"+autoreDto.getCognome());
        sendMail(autore.getEmail());

        autoreRepository.save(autore);
        return "Autore  con id"+autore.getId()+"creata con successo";
    }

    public Optional<Autore> getAutoreById(int id){
        return autoreRepository.findById(id);
    }

    public Page<Autore> getAllAutori( int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return autoreRepository.findAll(pageable);
    }





    public Autore updateAutore(int id, AutoreDto autoreDto) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = getAutoreById(id);
        if(autoreOptional.isPresent()){
            Autore autore = autoreOptional.get();

            autore.setNome(autoreDto.getNome());
            autore.setCognome(autoreDto.getCognome());
            autore.setDataDiNascita(autoreDto.getDataDiNascita());
            autore.setEmail(autoreDto.getEmail());
            return autoreRepository.save(autore);
        }
        throw new AutoreNonTrovatoException("Autore con id= "+id+" non trovata");
    }

    public String deleteAutore(int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = getAutoreById(id);
        if(autoreOptional.isPresent()){
          autoreRepository.delete(autoreOptional.get());
            return "Autore con id= "+id+ "eliminata con successo";
        }
        throw new AutoreNonTrovatoException("Autore con id="+id+" non trovata");
    }

    public String patchAvatarAutore(int id, MultipartFile avatar) throws IOException {
        Optional<Autore> autoreOpt = getAutoreById(id);
        if (autoreOpt.isPresent()) {

            String url = (String) cloudinary.uploader().upload(avatar.getBytes(), Collections.emptyMap()).get("url");
            Autore autore = autoreOpt.get();
            autore.setAvatar(url);
            autoreRepository.save(autore);
            return "Autore con id" + id + " aggiornato correttamente la cover inviata";
        } else {
            throw new BlogPostNonTrovatoException("Studente non trovato");
        }
    }

    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione Servizio rest");//oggetto dell' email
        message.setText("Registrazione al servizio rest avvenuta con successo");//corpo dell'email

        javaMailSender.send(message);
    }
    }
