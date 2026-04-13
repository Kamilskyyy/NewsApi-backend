package pl.edu.pwr.news.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(unique = true)
    private String name;



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<UserLanguage> languages;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<UserKeyword> keywords;



    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<UserLanguage> getLanguages() { return languages; }
    public void setLanguages(List<UserLanguage> languages) { this.languages = languages; }

    public List<UserKeyword> getKeywords() { return keywords; }
    public void setKeywords(List<UserKeyword> keywords) { this.keywords = keywords; }
}