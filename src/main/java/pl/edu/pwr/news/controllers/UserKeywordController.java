package pl.edu.pwr.news.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.news.models.User;
import pl.edu.pwr.news.models.UserKeyword;
import pl.edu.pwr.news.repository.UserKeywordRepository;
import pl.edu.pwr.news.repository.UserRepository;
import pl.edu.pwr.news.views.Views;

import java.util.List;

@RestController
@RequestMapping("/keywords")
public class UserKeywordController {

    private final UserKeywordRepository keywordRepository;
    private final UserRepository userRepository;

    public UserKeywordController(UserKeywordRepository keywordRepository, UserRepository userRepository) {
        this.keywordRepository = keywordRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserKeyword> getAll() {
        return keywordRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserKeyword getOne(@PathVariable int id) {
        return keywordRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public UserKeyword create(@RequestBody UserKeyword keyword, @RequestParam int userId) {
        User user = userRepository.findById(userId).orElseThrow();
        keyword.setUser(user);
        return keywordRepository.save(keyword);
    }

    @PutMapping("/{id}")
    public UserKeyword update(@PathVariable int id, @RequestBody UserKeyword updated) {
        UserKeyword keyword = keywordRepository.findById(id).orElseThrow();

        keyword.setKeyword(updated.getKeyword());

        return keywordRepository.save(keyword);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        keywordRepository.deleteById(id);
    }
}
