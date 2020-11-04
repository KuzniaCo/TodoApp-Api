package pl.ug.kuznia.todoappapi.internal.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserDTO userDTO) {
        User userToAdd = userDTO.createUser();
        return userRepository.save(userToAdd);
    }

    public boolean deleteUserById(Long id) {
        Optional<User> tempUser = userRepository.findById(id);

        if (tempUser.isEmpty()) {
            return false;
        }
        userRepository.delete(tempUser.get());
        return true;

    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public boolean logInUser(UserDTO userDTO) {
        Optional<User> foundUser = userRepository.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
        return foundUser.isPresent();
    }

    public User searchUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
