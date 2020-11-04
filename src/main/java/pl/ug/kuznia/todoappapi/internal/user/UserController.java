package pl.ug.kuznia.todoappapi.internal.user;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> showUser() {
        return userService.findAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User searchUserById(@PathVariable Long id) {
        return userService.searchUserById(id);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }

    @PostMapping
    public boolean logInUser(@RequestBody UserDTO userDTO){
        return userService.logInUser(userDTO);
    }
}
