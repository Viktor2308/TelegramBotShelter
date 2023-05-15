package com.example.telegrambotshelter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DogDTO {
    private String id;
    private String breed;
    private String dogName;
    private String yearOfBirthday;
    private String description;
}
