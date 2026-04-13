package pl.edu.pwr.news.controllers;

import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.news.dto.LanguageDTO;
import pl.edu.pwr.news.models.User;
import pl.edu.pwr.news.models.UserLanguage;
import pl.edu.pwr.news.repository.UserLanguageRepository;
import pl.edu.pwr.news.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class UserLanguageController {

    private final UserLanguageRepository repo;
    private final UserRepository userRepo;
    private final UserLanguageRepository userLanguageRepository;

    public UserLanguageController(UserLanguageRepository repo, UserRepository userRepo, UserLanguageRepository userLanguageRepository) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.userLanguageRepository = userLanguageRepository;
    }

    @GetMapping
    public List<UserLanguage> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public UserLanguage getOne(@PathVariable int id) {
        UserLanguage userLanguage = userLanguageRepository.findById(id).orElseThrow();
        return userLanguage;
    }

    @PostMapping
    public UserLanguage create(@RequestBody LanguageDTO dto, @RequestParam int userId) {
        User user = userRepo.findById(userId).orElseThrow();

        UserLanguage l = new UserLanguage();
        l.setLanguage(dto.getLanguage());
        l.setAbbreviation(dto.getAbbreviation());
        l.setUser(user);

        return repo.save(l);
    }

    @PutMapping("/{id}")
    public UserLanguage update(@PathVariable int id, @RequestBody LanguageDTO dto) {
        UserLanguage l = repo.findById(id).orElseThrow();

        l.setLanguage(dto.getLanguage());
        l.setAbbreviation(dto.getAbbreviation());

        return repo.save(l);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repo.deleteById(id);
    }
}