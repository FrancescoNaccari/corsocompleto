package nextDves.esercizio.controller;

import nextDves.esercizio.exception.AutoreNonTrovatoException;
import nextDves.esercizio.model.Autore;
import nextDves.esercizio.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @PostMapping("/api/autori")
    public String saveAutore(@RequestBody Autore autore) {
        return autoreService.saveAutore(autore);
    }

    @GetMapping("/api/autori")
    public List<Autore> getAllAutori() {
     return autoreService.getAllAutori();
    }

    @GetMapping("/api/autori/{id}")
    public Autore getAutoreById(@PathVariable int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = autoreService.getAutoreById(id);
        if (autoreOptional.isPresent()) {
            return autoreOptional.get();
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato: " + id);
        }
    }

    @PutMapping("/api/autori/{id}")
    public Autore updateAutore(@PathVariable int id, @RequestBody Autore autoreUp) throws AutoreNonTrovatoException {
        return autoreService.updateAutore(id, autoreUp);
    }

    @DeleteMapping("/api/autori/{id}")
    public String deleteAutore(@PathVariable int id) throws AutoreNonTrovatoException {
        return autoreService.deleteAutore(id);
    }

}
