package pl.edu.pwr.news.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.news.models.User;
import pl.edu.pwr.news.repository.UserRepository;
import pl.edu.pwr.news.views.Views;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // naprawić userów

    @GetMapping
    @JsonView(Views.UserView.class)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id).orElseThrow();

        user.setEmail(updatedUser.getEmail());
        user.setName(updatedUser.getName());
        user.setPassword(updatedUser.getPassword());

        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}