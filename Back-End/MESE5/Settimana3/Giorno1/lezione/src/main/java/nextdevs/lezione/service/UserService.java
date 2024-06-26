package nextdevs.lezione.service;

import nextdevs.lezione.dto.UserDto;
import nextdevs.lezione.entity.User;
import nextdevs.lezione.excepion.UserNotFoundException;
import nextdevs.lezione.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

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
            u.setPassword(userDto.getPassword());

            return userRepository.save(u);

        }else {
           throw new UserNotFoundException("User with id= " + id + " not found");
        }
    }

    public String deleteUser(int id) {
        Optional<User> userOptional = getUserById(id);

        if(userOptional.isPresent()) {
         userRepository.deleteById(id);
            return "User with id= " + id + " correctly deleted";
        }else {
            throw new UserNotFoundException("User with id= " + id + " not found");
        }
    }

    public User getUserByEmail(String email) {
        Optional<User> userOptional= userRepository.findByEmail(email);

        if (userOptional.isPresent()){
            return userOptional.get();
        }else {
            throw new UserNotFoundException("User with email=" + email + " not found");
        }
    }


}
