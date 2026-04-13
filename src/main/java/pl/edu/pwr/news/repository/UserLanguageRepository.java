package pl.edu.pwr.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.news.models.UserLanguage;

public interface UserLanguageRepository extends JpaRepository<UserLanguage, Integer> {
}
