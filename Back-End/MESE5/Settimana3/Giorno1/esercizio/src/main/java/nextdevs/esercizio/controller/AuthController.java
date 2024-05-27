package nextdevs.esercizio.controller;


import nextdevs.esercizio.dto.DipendenteDto;
import nextdevs.esercizio.dto.DipendenteLoginDto;
import nextdevs.esercizio.exception.BadRequestException;
import nextdevs.esercizio.service.AuthService;
import nextdevs.esercizio.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private DipendenteService dipendenteService;



    @PostMapping("/auth/register")
    public String saveDipendente(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage()).reduce("",((s1,s2) -> s1+s2)));
        }
        return dipendenteService.saveDipendente(dipendenteDto);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated DipendenteLoginDto dipendenteLoginDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(error->error.getDefaultMessage()).
                    reduce("", (s, s2) -> s+s2));
        }

        return authService.authenticateDipendenteAndCreateToken(dipendenteLoginDto);
    }





}
