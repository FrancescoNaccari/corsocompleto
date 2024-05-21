package nextDves.lezione.service;

import nextDves.lezione.exception.StudenteNonTrovaroException;
import nextDves.lezione.model.Studente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {

    private List<Studente> studenti=new ArrayList<>();



    public Optional<Studente> getStudenteByMatricola(int matricola){
      return studenti.stream().filter(s->s.getMatricola()==matricola).findFirst();

    }

    public List<Studente> getAllStudenti(){
        return studenti;
    }

    public String saveStudente(Studente studente){
        studenti.add(studente);
        return "Studente salvato con successo: "+ studente.getMatricola();
    }

    public Studente updateStudente(int matricola, Studente studenteUpd) throws StudenteNonTrovaroException {
        Optional<Studente> studenteOpt = getStudenteByMatricola(matricola);
        if (studenteOpt.isPresent()) {
            Studente studente = studenteOpt.get();
            studente.setNome(studenteUpd.getNome());
            studente.setCognome(studenteUpd.getCognome());
            studente.setDataDiNascita(studenteUpd.getDataDiNascita());
            return studente;
        }
        else {
            throw new StudenteNonTrovaroException("Studente non trovato");
        }

    }

    public String deleteStudente(int matricola) throws StudenteNonTrovaroException {
        Optional<Studente> studenteOpt = getStudenteByMatricola(matricola);
        if (studenteOpt.isPresent()) {
            studenti.remove(studenteOpt.get());
            return "Studente eliminato con successo";
        }
        else {
            throw new StudenteNonTrovaroException("Studente non trovato");
        }

    }
}
