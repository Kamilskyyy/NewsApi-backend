package pl.edu.pwr.news.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import pl.edu.pwr.news.views.Views;

@Entity
@Table(name = "user_keywords")
public class UserKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UserView.class)
    private int id;

    @Column(name = "user_id", insertable = false, updatable = false)
    private int userId;

    @JsonView(Views.UserView.class)
    private String keyword;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;




    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}