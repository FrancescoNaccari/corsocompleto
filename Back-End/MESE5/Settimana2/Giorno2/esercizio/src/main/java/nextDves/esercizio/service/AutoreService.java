package nextDves.esercizio.service;

import nextDves.esercizio.exception.AutoreNonTrovatoException;
import nextDves.esercizio.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {
    private List<Autore> autori = new ArrayList<>();

    public Optional<Autore> getAutoreById(int id){
        return autori.stream().filter(a -> a.getId() == id).findFirst();
    }

    public List<Autore> getAllAutori(){
        return autori;
    }

    public String saveAutore(Autore autore){
        autori.add(autore);
        return "Autore salvato con successo: " + autore.getId();
    }

    public Autore updateAutore(int id, Autore autoreUp) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = getAutoreById(id);
        if(autoreOptional.isPresent()){
            Autore autore = autoreOptional.get();
            autore.setNome(autoreUp.getNome());
            autore.setCognome(autoreUp.getCognome());
            autore.setDataDiNascita(autoreUp.getDataDiNascita());
            autore.setEmail(autoreUp.getEmail());
            return autore;
        }
        throw new AutoreNonTrovatoException("Autore non trovato");
    }

    public String deleteAutore(int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = getAutoreById(id);
        if(autoreOptional.isPresent()){
            autori.remove(autoreOptional.get());
            return "Autore eliminato con successo";
        }
        throw new AutoreNonTrovatoException("Autore non trovato");
    }
}
