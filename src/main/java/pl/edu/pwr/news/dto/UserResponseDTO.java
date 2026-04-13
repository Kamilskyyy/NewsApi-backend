package pl.edu.pwr.news.dto;

import java.util.List;

public class UserResponseDTO {

    private int id;
    private String email;
    private String password;
    private String name;

    private List<LanguageResponseDTO> languages;
    private List<KeywordResponseDTO> keywords;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<LanguageResponseDTO> getLanguages() { return languages; }
    public void setLanguages(List<LanguageResponseDTO> languages) { this.languages = languages; }

    public List<KeywordResponseDTO> getKeywords() { return keywords; }
    public void setKeywords(List<KeywordResponseDTO> keywords) { this.keywords = keywords; }
}