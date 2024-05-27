package nextdevs.lezione.service;

import nextdevs.lezione.dto.UserLoginDto;
import nextdevs.lezione.entity.User;
import nextdevs.lezione.excepion.UnauthorizedException;
import nextdevs.lezione.excepion.UserNotFoundException;
import nextdevs.lezione.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserService userService;

    @Autowired
    private JwtTool jwtTool;

    public String authenticateUserAndCreateToken(UserLoginDto userLoginDto) {
        User user= userService.getUserByEmail(userLoginDto.getEmail());

        if (user.getPassword().equals(userLoginDto.getPassword())){
            return jwtTool.createToken(user);
        }else {
            throw new UnauthorizedException("Error in authorization, relogin!");
        }

    }

}
