package nextDevs.esercizio.service;


import nextDevs.esercizio.dto.AutoreDto;
import nextDevs.esercizio.exception.AutoreNonTrovatoException;
import nextDevs.esercizio.model.Autore;
import nextDevs.esercizio.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;


    public String saveAutore(AutoreDto autoreDto) {
        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setEmail(autoreDto.getEmail());
        autore.setDataDiNascita(autoreDto.getDataDiNascita());
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
}
