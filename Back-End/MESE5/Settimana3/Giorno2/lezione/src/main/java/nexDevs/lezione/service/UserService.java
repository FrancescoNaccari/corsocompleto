package nexDevs.lezione.service;


import nexDevs.lezione.dto.UserDto;
import nexDevs.lezione.entity.Role;
import nexDevs.lezione.entity.User;
import nexDevs.lezione.excepion.NotFoundException;
import nexDevs.lezione.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setRole(Role.USER);
        user.setPassword( passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);
        return "User with id=" + user.getId() + "correctly saved";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional <User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User updateUser(int id,UserDto userDto) {
        Optional<User> user = getUserById(id);

        if(user.isPresent()) {
            User u = user.get();
            u.setName(userDto.getName());
            u.setSurname(userDto.getSurname());
            u.setEmail(userDto.getEmail());
            u.setPassword( passwordEncoder.encode(userDto.getPassword()));

            return userRepository.save(u);

        }else {
           throw new NotFoundException("User with id= " + id + " not found");
        }
    }

    public String deleteUser(int id) {
        Optional<User> userOptional = getUserById(id);

        if(userOptional.isPresent()) {
         userRepository.deleteById(id);
            return "User with id= " + id + " correctly deleted";
        }else {
            throw new NotFoundException("User with id= " + id + " not found");
        }
    }

    public User getUserByEmail(String email) {
        Optional<User> userOptional= userRepository.findByEmail(email);

        if (userOptional.isPresent()){
            return userOptional.get();
        }else {
            throw new NotFoundException("User with email=" + email + " not found");
        }
    }


}
