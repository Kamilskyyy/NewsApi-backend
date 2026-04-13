package pl.edu.pwr.news.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "user_languages")
public class UserLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", insertable = false, updatable = false)
    private int userId;

    private String language;

    private String abbreviation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;



    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getAbbreviation() { return abbreviation; }
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}