package com.example.telegrambotshelter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DogDto {
    private String breed;
    private String name;
    private int yearOfBirthday;
    private String description;
}
