package pl.edu.pwr.news.dto;

public class LanguageResponseDTO {

    private int id;
    private String language;
    private String abbreviation;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getAbbreviation() { return abbreviation; }
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }
}