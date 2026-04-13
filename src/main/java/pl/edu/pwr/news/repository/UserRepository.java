package pl.edu.pwr.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.news.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}