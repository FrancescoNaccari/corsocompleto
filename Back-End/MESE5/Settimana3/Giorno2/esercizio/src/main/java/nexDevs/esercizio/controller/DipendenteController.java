package nexDevs.esercizio.controller;



import nexDevs.esercizio.dto.DipendenteDto;
import nexDevs.esercizio.exception.BadRequestException;
import nexDevs.esercizio.exception.DipendenteNonTrovatoException;
import nexDevs.esercizio.model.Dipendente;
import nexDevs.esercizio.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;





    @GetMapping("/dipendenti")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Page<Dipendente> getAllAutori(@RequestParam (defaultValue = "0") int page,
                                         @RequestParam (defaultValue = "15") int size,
                                         @RequestParam (defaultValue = "id") String sortBy) {
        return dipendenteService.getAllDipendente(page, size, sortBy);
    }

    @GetMapping("/dipendenti/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Dipendente getDipendenteById(@PathVariable int id) throws DipendenteNonTrovatoException {
        Optional<Dipendente> dipendentiOptional = dipendenteService.getDipendenteById(id);
        if (dipendentiOptional.isPresent()) {
            return dipendentiOptional.get();
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id: "+id+" non trovata");
        }
    }

    @PutMapping("/dipendenti/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Dipendente updateDipendente(@PathVariable int id, @RequestBody @Validated DipendenteDto dipendentiDto, BindingResult bindingResult) throws DipendenteNonTrovatoException {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage()).reduce("",((s1,s2) -> s1+s2)));
        }
        return dipendenteService.updateDipendente(id, dipendentiDto);
    }

    @DeleteMapping("/dipendenti/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteDipendente(@PathVariable int id) throws DipendenteNonTrovatoException {
        return dipendenteService.deleteDipendente(id);
    }
    @PatchMapping ("/dipendenti/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public String patchAvatarDipendente(@RequestBody MultipartFile avatar, @PathVariable int id) throws IOException {
        return dipendenteService.patchAvatarDipendente(id, avatar);

    }

}
