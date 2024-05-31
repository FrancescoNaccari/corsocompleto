package nextDevs.GestioneEventi.service;

import nextDevs.GestioneEventi.dto.UtenteLoginDto;
import nextDevs.GestioneEventi.entity.Utente;
import nextDevs.GestioneEventi.excepion.UnauthorizedException;
import nextDevs.GestioneEventi.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired

    UtenteService utenteService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTool jwtTool;

    public String authenticateUtentiAndCreateToken(UtenteLoginDto utenteLoginDto) {
        Optional <Utente> utenteOptional = utenteService.getUtenteByEmail(utenteLoginDto.getEmail());
        if (utenteOptional.isEmpty()) {
            throw new UnauthorizedException("Error in authorization, relogin!");
        }else{
            Utente utente= utenteOptional.get();
            if (utente.getPassword().equals(utenteLoginDto.getPassword())){
                return jwtTool.createToken(utente);
            }else {
                throw new UnauthorizedException("Error in authorization, relogin!");
            }
        }


    }

    }




