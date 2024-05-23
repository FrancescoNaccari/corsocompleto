package nextDevs.lezione.service;

import com.cloudinary.Cloudinary;
import nextDevs.lezione.dto.StudenteDto;
import nextDevs.lezione.exception.AulaNonTrovataException;
import nextDevs.lezione.exception.StudenteNonTrovaroException;
import nextDevs.lezione.model.Aula;
import nextDevs.lezione.model.Studente;
import nextDevs.lezione.repository.AulaRepository;
import nextDevs.lezione.repository.StudenteRepository;
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
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;
    @Autowired
    private AulaRepository aulaRepository;
    @Autowired
    private Cloudinary cloudinary ;
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public String saveStudente(StudenteDto studenteDto){
        Studente studente = new Studente();
        studente.setNome(studenteDto.getNome());
        studente.setCognome(studenteDto.getCognome());
        studente.setDataDiNascita(studenteDto.getDataDiNascita());
        studente.setEmail(studenteDto.getEmail());

        Optional<Aula> aulaOptional= aulaRepository.findById(studenteDto.getAulaId());
        if(aulaOptional.isPresent()){
            Aula aula= aulaOptional.get();
            studente.setAula(aula);
            studenteRepository.save(studente);
            sendMail(studente.getEmail()); //serve per inviare la mail allo studente in fase di creazione dello studente
            return "Studente con matricola "+ studente.getMatricola()+ "salvato con successo";
        }else {
            throw new AulaNonTrovataException("Aula con id" + studenteDto.getAulaId()  +"non trovata");
        }


    }


    public Page<Studente> getStudenti( int page, int size , String sortBy){
        Pageable pageable= PageRequest.of(page, size, Sort.by(sortBy));
        return studenteRepository.findAll(pageable);
    }




    public Optional <Studente> getStudenteById(int matricola){
        return studenteRepository.findById(matricola);
    }

       public Studente updateStudente(int matricola, StudenteDto studenteDto){
        Optional<Studente> studenteOptional = getStudenteById(matricola);

        if(studenteOptional.isPresent()){
            Studente studente = studenteOptional.get();

            studente.setNome(studenteDto.getNome());
            studente.setCognome(studenteDto.getCognome());
            studente.setDataDiNascita(studenteDto.getDataDiNascita());

            Optional<Aula> aulaOptional=aulaRepository.findById(studenteDto.getAulaId());

            if(aulaOptional.isPresent()){
                Aula aula = aulaOptional.get();
                studente.setAula(aula);
                studenteRepository.save(studente);

                return studente;
            }
            else{
                throw new AulaNonTrovataException("Aula con id=" + studenteDto.getAulaId() + " non trovata");
            }
        }
        else{
            throw new StudenteNonTrovaroException("Studente con matricola=" + matricola + " non trovato");
        }
    }

    public String deleteStudente(int matricola) throws StudenteNonTrovaroException {
        Optional<Studente> studenteOpt = getStudenteById(matricola);
        if (studenteOpt.isPresent()) {
            studenteRepository.delete(studenteOpt.get());
            return "Studente con matricola" +matricola +" eliminato con successo";
        }
        else {
            throw new StudenteNonTrovaroException("Studente non trovato");
        }
    }


    public String patchFotoStudente(int matricola, MultipartFile foto) throws IOException {
        Optional<Studente> studenteOpt = getStudenteById(matricola);
        if (studenteOpt.isPresent()) {

            String url = (String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Studente studente = studenteOpt.get();
            studente.setFoto(url);
            studenteRepository.save(studente);
            return "Studente con matricola" +matricola +" aggiornato correttamnete la foto inviata";
        }else {
            throw new StudenteNonTrovaroException("Studente non trovato");
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
