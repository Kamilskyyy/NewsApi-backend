package pl.edu.pwr.news.controllers;

import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.news.models.User;
import pl.edu.pwr.news.models.UserLanguage;
import pl.edu.pwr.news.repository.UserLanguageRepository;
import pl.edu.pwr.news.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class UserLanguageController {

    private final UserLanguageRepository languageRepository;
    private final UserRepository userRepository;

    public UserLanguageController(UserLanguageRepository languageRepository, UserRepository userRepository) {
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserLanguage> getAll() {
        return languageRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserLanguage getOne(@PathVariable int id) {
        return languageRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public UserLanguage create(@RequestBody UserLanguage lang, @RequestParam int userId) {
        User user = userRepository.findById(userId).orElseThrow();
        lang.setUser(user);
        return languageRepository.save(lang);
    }

    @PutMapping("/{id}")
    public UserLanguage update(@PathVariable int id, @RequestBody UserLanguage updated) {
        UserLanguage lang = languageRepository.findById(id).orElseThrow();

        lang.setLanguage(updated.getLanguage());
        lang.setAbbreviation(updated.getAbbreviation());

        return languageRepository.save(lang);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        languageRepository.deleteById(id);
    }
}