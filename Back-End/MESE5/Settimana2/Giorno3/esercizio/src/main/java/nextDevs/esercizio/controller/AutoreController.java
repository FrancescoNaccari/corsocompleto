package nextDevs.esercizio.controller;


import nextDevs.esercizio.dto.AutoreDto;
import nextDevs.esercizio.exception.AutoreNonTrovatoException;
import nextDevs.esercizio.model.Autore;
import nextDevs.esercizio.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @PostMapping("/autori")
    public String saveAutore(@RequestBody AutoreDto autoreDto) {
        return autoreService.saveAutore(autoreDto);
    }

    @GetMapping("/autori")
    public Page<Autore> getAllAutori(@RequestParam (defaultValue = "0") int page,
                                     @RequestParam (defaultValue = "15") int size,
                                     @RequestParam (defaultValue = "id") String sortBy) {
     return autoreService.getAllAutori(page, size, sortBy);
    }

    @GetMapping("autori/{id}")
    public Autore getAutoreById(@PathVariable int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = autoreService.getAutoreById(id);
        if (autoreOptional.isPresent()) {
            return autoreOptional.get();
        } else {
            throw new AutoreNonTrovatoException("Autore con id: "+id+" non trovata");
        }
    }

    @PutMapping("/autori/{id}")
    public Autore updateAutore(@PathVariable int id, @RequestBody AutoreDto autoreDto) throws AutoreNonTrovatoException {
        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("/autori/{id}")
    public String deleteAutore(@PathVariable int id) throws AutoreNonTrovatoException {
        return autoreService.deleteAutore(id);
    }

}
