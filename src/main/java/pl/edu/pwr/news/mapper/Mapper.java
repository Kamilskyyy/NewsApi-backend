package pl.edu.pwr.news.mapper;

import pl.edu.pwr.news.models.User;
import pl.edu.pwr.news.dto.*;
import java.util.stream.Collectors;

public class Mapper {

    public static UserResponseDTO toUserDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setName(user.getName());

        if (user.getLanguages() != null) {
            dto.setLanguages(user.getLanguages().stream().map(lang -> {
                LanguageResponseDTO l = new LanguageResponseDTO();
                l.setId(lang.getId());
                l.setLanguage(lang.getLanguage());
                l.setAbbreviation(lang.getAbbreviation());
                return l;
            }).collect(Collectors.toList()));
        }

        if (user.getKeywords() != null) {
            dto.setKeywords(user.getKeywords().stream().map(k -> {
                KeywordResponseDTO kw = new KeywordResponseDTO();
                kw.setId(k.getId());
                kw.setKeyword(k.getKeyword());
                return kw;
            }).collect(Collectors.toList()));
        }

        return dto;
    }

    public static UserGet toDTO(User user) {
        UserGet dto = new UserGet();

        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());

        return dto;
    }
}