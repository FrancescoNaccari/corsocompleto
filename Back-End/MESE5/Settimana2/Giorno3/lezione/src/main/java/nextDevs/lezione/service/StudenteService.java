package nextDevs.lezione.service;

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
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;
    @Autowired
    private AulaRepository aulaRepository;

    public String saveStudente(StudenteDto studenteDto){
        Studente studente = new Studente();
        studente.setNome(studenteDto.getNome());
        studente.setCognome(studenteDto.getCognome());
        studente.setDataDiNascita(studenteDto.getDataDiNascita());

        Optional<Aula> aulaOptional= aulaRepository.findById(studenteDto.getAulaId());
        if(aulaOptional.isPresent()){
            Aula aula= aulaOptional.get();
            studente.setAula(aula);
            studenteRepository.save(studente);
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
}
