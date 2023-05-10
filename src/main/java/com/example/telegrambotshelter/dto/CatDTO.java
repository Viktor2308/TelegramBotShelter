package com.example.telegrambotshelter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatDTO {
    private String id;
    private String breed;
    private String catName;
    private String yearOfBirthday;
    private String description;
}
