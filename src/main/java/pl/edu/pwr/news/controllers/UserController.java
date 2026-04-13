package pl.edu.pwr.news.controllers;

import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.news.mapper.Mapper;
import pl.edu.pwr.news.models.User;
import pl.edu.pwr.news.repository.UserRepository;
import pl.edu.pwr.news.dto.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/full")
    public List<UserResponseDTO> getFullAll() {
        return userRepository.findAll().stream()
                .map(Mapper::toUserDTO)
                .toList();
    }

    @GetMapping("/full/{id}")
    public UserResponseDTO getFullOne(@PathVariable int id) {
        User user = userRepository.findById(id).orElseThrow();
        return Mapper.toUserDTO(user);
    }

    @GetMapping
    public List<UserGet> getAll() {
        return userRepository.findAll().stream()
                .map(Mapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public UserGet getOne(@PathVariable int id) {
        User user = userRepository.findById(id).orElseThrow();
        return Mapper.toDTO(user);
    }

    @PostMapping
    public UserResponseDTO create(@RequestBody UserCreateDTO dto) {
        User user = new User();

        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());

        return Mapper.toUserDTO(userRepository.save(user));
    }

    @PutMapping("/{id}")
    public UserResponseDTO update(@PathVariable int id, @RequestBody UserCreateDTO dto) {
        User user = userRepository.findById(id).orElseThrow();

        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());

        return Mapper.toUserDTO(userRepository.save(user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}