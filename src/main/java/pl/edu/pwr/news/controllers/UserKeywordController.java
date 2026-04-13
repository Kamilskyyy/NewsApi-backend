package pl.edu.pwr.news.controllers;

import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.news.dto.KeywordDTO;
import pl.edu.pwr.news.models.User;
import pl.edu.pwr.news.models.UserKeyword;
import pl.edu.pwr.news.repository.UserKeywordRepository;
import pl.edu.pwr.news.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/keywords")
public class UserKeywordController {

    private final UserKeywordRepository repo;
    private final UserRepository userRepo;
    private final UserKeywordRepository userKeywordRepository;

    public UserKeywordController(UserKeywordRepository repo, UserRepository userRepo, UserKeywordRepository userKeywordRepository) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.userKeywordRepository = userKeywordRepository;
    }

    @GetMapping
    public List<UserKeyword> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public UserKeyword getOne(@PathVariable int id) {
        UserKeyword userKeyword = userKeywordRepository.findById(id).orElseThrow();
        return userKeyword;
    }

    @PostMapping
    public UserKeyword create(@RequestBody KeywordDTO dto, @RequestParam int userId) {
        User user = userRepo.findById(userId).orElseThrow();

        UserKeyword k = new UserKeyword();
        k.setKeyword(dto.getKeyword());
        k.setUser(user);

        return repo.save(k);
    }

    @PutMapping("/{id}")
    public UserKeyword update(@PathVariable int id, @RequestBody KeywordDTO dto) {
        UserKeyword k = repo.findById(id).orElseThrow();

        k.setKeyword(dto.getKeyword());

        return repo.save(k);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repo.deleteById(id);
    }
}
