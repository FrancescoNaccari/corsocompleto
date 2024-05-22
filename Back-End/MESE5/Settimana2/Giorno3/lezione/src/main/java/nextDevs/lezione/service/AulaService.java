package nextDevs.lezione.service;

import nextDevs.lezione.dto.AulaDto;
import nextDevs.lezione.exception.AulaNonTrovataException;
import nextDevs.lezione.model.Aula;
import nextDevs.lezione.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AulaService {
    @Autowired
    private AulaRepository aulaRepository;

    public String saveAula(AulaDto aulaDto){
        Aula aula= new Aula();
        aula.setNome(aulaDto.getNome());
        aula.setPiano(aulaDto.getPiano());

        aulaRepository.save(aula);
        return "Aula con id"+aula.getId()+"creata con successo";
    }


    public Page<Aula> getAule(int page, int size , String sortBy){
        Pageable pageable= PageRequest.of(page, size, Sort.by(sortBy));
        return aulaRepository.findAll(pageable);
    }

    public Optional<Aula> getAulaById(int id){
        return aulaRepository.findById(id);
    }

    public Aula updateAula(int id, AulaDto aulaDto){
        Optional<Aula> aulaOpt = getAulaById(id);
        if (aulaOpt.isPresent()) {
            Aula aula = aulaOpt.get();
            aula.setNome(aulaDto.getNome());
            aula.setPiano(aulaDto.getPiano());
            return aulaRepository.save(aula);
        }else {
            throw new AulaNonTrovataException("Aula con id="+id+" non trovata");
        }
    }

    public String deleteAula(int id){
        Optional<Aula> aulaOpt = getAulaById(id);
        if (aulaOpt.isPresent()) {
            aulaRepository.delete(aulaOpt.get());
            return "Aula  con id="+id+ "eliminata con successo";
        }else {
            throw new AulaNonTrovataException("Aula con id="+id+" non trovata");
        }
    }


}
