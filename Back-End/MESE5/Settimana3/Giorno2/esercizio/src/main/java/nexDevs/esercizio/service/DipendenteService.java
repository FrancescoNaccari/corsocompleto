package nexDevs.esercizio.service;



import com.cloudinary.Cloudinary;
import nexDevs.esercizio.dto.DipendenteDto;
import nexDevs.esercizio.enums.Role;
import nexDevs.esercizio.exception.BadRequestException;
import nexDevs.esercizio.exception.DipendenteNonTrovatoException;
import nexDevs.esercizio.model.Dipendente;
import nexDevs.esercizio.repository.DipendeteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Service
public class DipendenteService {
    @Autowired
    private DipendeteRepository dipendenteRepository;
    @Autowired
    private Cloudinary cloudinary ;
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveDipendente(DipendenteDto dipendenteDto) {

        if(getDipendenteByEmail(dipendenteDto.getEmail()).isEmpty()) {
            Dipendente dipendente = new Dipendente();
            dipendente.setUsername(dipendenteDto.getUsername());
            dipendente.setNome(dipendenteDto.getNome());
            dipendente.setCognome(dipendenteDto.getCognome());
            dipendente.setEmail(dipendenteDto.getEmail());
            dipendente.setRole(Role.USER);
            dipendente.setPassword( passwordEncoder.encode(dipendenteDto.getPassword()));
            dipendente.setAvatar("https://ui-avatars.com/api/?name="+dipendenteDto.getNome()+"+"+dipendenteDto.getCognome());
            sendMail(dipendente.getEmail());

            dipendenteRepository.save(dipendente);
            return "Dipendente  con id"+dipendente.getId()+"creata con successo";
        }else{
            throw new BadRequestException("Dipendente con email "+dipendenteDto.getEmail()+" già esistente");
        }

    }

    public Optional<Dipendente> getDipendenteById(int id){
        return dipendenteRepository.findById(id);
    }

    public Page<Dipendente> getAllDipendente(int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return dipendenteRepository.findAll(pageable);
    }





    public Dipendente updateDipendente(int id, DipendenteDto dipendenteDto) throws DipendenteNonTrovatoException {
        Optional<Dipendente> dipendenteOptional = getDipendenteById(id);
        if(dipendenteOptional.isPresent()){
            Dipendente dipendente = dipendenteOptional.get();
            dipendente.setUsername(dipendenteDto.getUsername());
            dipendente.setNome(dipendenteDto.getNome());
            dipendente.setCognome(dipendenteDto.getCognome());
            dipendente.setEmail(dipendenteDto.getEmail());
            dipendente.setPassword( passwordEncoder.encode(dipendenteDto.getPassword()));
            return dipendenteRepository.save(dipendente);
        }
        throw new DipendenteNonTrovatoException("Dipendente con id= "+id+" non trovata");
    }

    public String deleteDipendente(int id) throws DipendenteNonTrovatoException {
        Optional<Dipendente> dipendenteOptional = getDipendenteById(id);

        if (dipendenteOptional.isPresent()) {
            dipendenteRepository.deleteById(id);
            return "User with id= " + id + " correctly deleted";
        } else {

            throw new DipendenteNonTrovatoException("Dipendente con id=" + id + " non trovata");
        }
    }


    public String patchAvatarDipendente(int id, MultipartFile avatar) throws IOException {
        Optional<Dipendente> dipendenteOpt = getDipendenteById(id);
        if (dipendenteOpt.isPresent()) {

            String url = (String) cloudinary.uploader().upload(avatar.getBytes(), Collections.emptyMap()).get("url");
            Dipendente dipendente = dipendenteOpt.get();
            dipendente.setAvatar(url);
            dipendenteRepository.save(dipendente);
            return "Dipendente con id" + id + " aggiornato correttamente la cover inviata";
        } else {
            throw new DipendenteNonTrovatoException("Studente non trovato");
        }
    }

    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione Servizio rest");//oggetto dell' email
        message.setText("Registrazione al servizio rest avvenuta con successo");//corpo dell'email

        javaMailSender.send(message);
    }

    public Optional <Dipendente> getDipendenteByEmail(String email) {
        Optional<Dipendente> dipendenteOptional= dipendenteRepository.findByEmail(email);

       return dipendenteOptional;
    }


}
