package nexDevs.lezione.service;


import nexDevs.lezione.dto.UserLoginDto;
import nexDevs.lezione.entity.User;
import nexDevs.lezione.excepion.UnauthorizedException;
import nexDevs.lezione.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTool jwtTool;

    public String authenticateUserAndCreateToken(UserLoginDto userLoginDto) {
        User user= userService.getUserByEmail(userLoginDto.getEmail());

        if (passwordEncoder.matches(userLoginDto.getPassword(),user.getPassword())) {
            return jwtTool.createToken(user);
        }else {
            throw new UnauthorizedException("Error in authorization, relogin!");
        }

    }



}
