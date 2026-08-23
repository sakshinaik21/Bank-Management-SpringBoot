package jsp_springBoot.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jsp_springBoot.Entity.User;
import jsp_springBoot.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // REGISTER USER
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {

        return userService.registerUser(user);
    }

    // LOGIN
    @PostMapping("/login")
    public User login(
            @RequestParam String username,
            @RequestParam String password) {

        return userService.login(username, password);
    }

    // GET ALL USERS
    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    // GET USER BY USERNAME
    @GetMapping("/username/{username}")
    public User getUserByUsername(
            @PathVariable String username) {

        return userService.getUserByUsername(username);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        return userService.deleteUser(id);
    }
}