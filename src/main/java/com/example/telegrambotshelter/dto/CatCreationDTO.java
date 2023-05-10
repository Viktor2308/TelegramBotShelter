package com.example.telegrambotshelter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class CatCreationDTO {

    @NotBlank
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Name must contain only letters a-z and A-Z")
    @Length(min = 2, max = 15, message = "Name length must be from 2 to 15")
    private String catName;
    @NotBlank
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Name must contain only letters a-z and A-Z")
    @Length(min = 2, max = 15, message = "Breed length must be from 2 to 15")
    private String breed;
    @NotBlank
    @Pattern(regexp = "^[0-9]+$", message = "Year of birthday must contain only nums")
    @Length(max = 4, message = "Name length must be from 0 to 4")
    private String yearOfBirthday;
    @NotBlank
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Name must contain only letters a-z and A-Z")
    @Length(min = 2, max = 25, message = "Name length must be from 2 to 15")
    private String description;


}
