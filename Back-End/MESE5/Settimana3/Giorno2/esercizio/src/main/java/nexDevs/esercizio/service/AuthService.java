package nexDevs.esercizio.service;


import nexDevs.esercizio.dto.DipendenteLoginDto;
import nexDevs.esercizio.exception.UnauthorizedException;
import nexDevs.esercizio.model.Dipendente;
import nexDevs.esercizio.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AuthService {

    @Autowired
  private DipendenteService dipendenteService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTool jwtTool;


    public String authenticateDipendenteAndCreateToken(DipendenteLoginDto dipendenteLoginDto) {
       Optional <Dipendente> dipendenteOptional = dipendenteService.getDipendenteByEmail(dipendenteLoginDto.getEmail());
      if (dipendenteOptional.isEmpty()) {
          throw new UnauthorizedException("Error in authorization, relogin!");
      }else{
          Dipendente dipendente= dipendenteOptional.get();
          if (passwordEncoder.matches(dipendenteLoginDto.getPassword(),dipendente.getPassword())){
              return jwtTool.createToken(dipendente);
          }else {
              throw new UnauthorizedException("Error in authorization, relogin!");
          }
      }


    }

}
