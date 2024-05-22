package nextDevs.lezione.controller;



import nextDevs.lezione.dto.StudenteDto;
import nextDevs.lezione.exception.StudenteNonTrovaroException;
import nextDevs.lezione.model.Studente;
import nextDevs.lezione.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudenteController {
    @Autowired
    private StudenteService studenteService;

    @PostMapping("/api/studenti")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveStudente(@RequestBody StudenteDto StudenteDto) {
        return studenteService.saveStudente( StudenteDto);
    }


    @GetMapping("/api/studenti")
    public Page<Studente> getAllStudenti(@RequestParam (defaultValue = "0") int page,
                                         @RequestParam (defaultValue = "15") int size,
                                         @RequestParam (defaultValue = "matricola") String sortBy) {
        return studenteService.getStudenti(page, size, sortBy);
    }


    @GetMapping("/api/studenti/{matricola}")
    public Studente getStudenteByMatricola(@PathVariable int matricola) throws StudenteNonTrovaroException {
        Optional<Studente> studenteOpt = studenteService.getStudenteById(matricola);
        if (studenteOpt.isPresent()) {
            return studenteOpt.get();
        } else {
            throw new StudenteNonTrovaroException("Studente con matricola: " + matricola + " non trovato");
        }
    }

    @PutMapping ( "/api/studenti/{matricola}")
    @ResponseStatus(HttpStatus.OK)
    public Studente updateStudente(@PathVariable int matricola, @RequestBody StudenteDto studenteDto) throws StudenteNonTrovaroException {
      return  studenteService.updateStudente(matricola, studenteDto);
    }

    @DeleteMapping ("/api/studenti/{matricola}")
    public String deleteStudente(@PathVariable int matricola) throws StudenteNonTrovaroException {
        return studenteService.deleteStudente(matricola);
    }

//
//    @GetMapping("/api")
//    public String benvenuto(){
//        return "Benvenuto";
//    }
//
//    @GetMapping("/api/nome_cognome")//gestisce le richieste con i query params(?nome=Sara&cognome=Rossi)
//    public String benvenuto2(@RequestParam String nome, String cognome){
//        return "Benvenuto " + nome + " " + cognome;
//    }
//
//    @GetMapping("/api/{nome}/{cognome}")//tra parentesi si mette la parte del path che sarà variabile
//    public String benvenuto3(@PathVariable String nome,@PathVariable  String cognome){
//        return "Benvenuto " + nome + " " + cognome;
//    }
//
//
//    @GetMapping("/api/body")//@RequestBody fa capiere a Spring che i dati deve recuperarli dal body della richiesta
//    public String benvenuto4(@RequestBody String nomeCognome){
//        return "Benvenuto " + nomeCognome;
//    }


}
