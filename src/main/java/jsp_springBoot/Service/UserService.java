package jsp_springBoot.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import jsp_springBoot.Entity.User;
import jsp_springBoot.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // REGISTER USER
    public User registerUser(User user) {

        if (userRepository.existsByUsername(user.getUsername())) {

            throw new RuntimeException(
                    "Username already exists");
        }

        if (userRepository.existsByEmail(user.getEmail())) {

            throw new RuntimeException(
                    "Email already exists");
        }

        return userRepository.save(user);
    }

    // GET ALL USERS
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    // GET USER BY ID
    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found with ID: " + id));
    }

    // GET USER BY USERNAME
    public User getUserByUsername(String username) {

        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found with username: "
                                        + username));
    }

    // LOGIN
    public User login(String username, String password) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Invalid username or password"));

        if (!user.getPassword().equals(password)) {

            throw new RuntimeException(
                    "Invalid username or password");
        }

        return user;
    }

    // DELETE USER
    public String deleteUser(Long id) {

        if (!userRepository.existsById(id)) {

            throw new RuntimeException(
                    "User not found with ID: " + id);
        }

        userRepository.deleteById(id);

        return "User deleted successfully";
    }
}