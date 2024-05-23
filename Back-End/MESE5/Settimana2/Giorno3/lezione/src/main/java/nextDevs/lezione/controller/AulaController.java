package nextDevs.lezione.controller;

import nextDevs.lezione.dto.AulaDto;
import nextDevs.lezione.exception.BadRequestException;
import nextDevs.lezione.model.Aula;
import nextDevs.lezione.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api")//per avere un path root di tutti i path. Viene aggiunto automaticamente
public class AulaController {
    @Autowired
    private AulaService aulaService;

    @PostMapping("/api/aule")
    public String saveAuto(@RequestBody @Validated AulaDto aulaDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage()).reduce("",((s1,s2) -> s1+s2)));
        }
        return aulaService.saveAula(aulaDto);
    }

    @GetMapping("/api/aule")
    public Page<Aula> getAule(@RequestParam (defaultValue = "0") int page,
                              @RequestParam (defaultValue = "15") int size,
                              @RequestParam (defaultValue = "matricola") String sortBy) {
        return aulaService.getAule(page, size, sortBy);
    }

    @GetMapping("/api/aule/{id}")
    public Aula getAulaById(@PathVariable int id){
       Optional<Aula> aulaOpt = aulaService.getAulaById(id);
       if(aulaOpt.isPresent()){
           return aulaOpt.get();
       }else{
           throw new RuntimeException("Aula con id: "+id+" non trovata");
       }
    }

    @PutMapping ("/api/aule/{id}")
    public Aula updateAula(@PathVariable int id, @RequestBody @Validated AulaDto aulaDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage()).reduce("",((s1,s2) -> s1+s2)));
        }
        return aulaService.updateAula(id,aulaDto);
    }


    @DeleteMapping ("/api/aule/{id}")
    public String deleteAula(@PathVariable int id){
        return aulaService.deleteAula(id);
    }

}
