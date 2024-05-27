package nextdevs.esercizio.service;


import nextdevs.esercizio.dto.DipendenteLoginDto;
import nextdevs.esercizio.exception.UnauthorizedException;
import nextdevs.esercizio.model.Dipendente;
import nextdevs.esercizio.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
   DipendenteService dipendenteService;

    @Autowired
    private JwtTool jwtTool;

    public String authenticateDipendenteAndCreateToken(DipendenteLoginDto dipendenteLoginDto) {
        Dipendente dipendente= dipendenteService.getDipendenteByEmail(dipendenteLoginDto.getEmail());

        if (dipendente.getPassword().equals(dipendenteLoginDto.getPassword())){
            return jwtTool.createToken(dipendente);
        }else {
            throw new UnauthorizedException("Error in authorization, relogin!");
        }

    }

}
