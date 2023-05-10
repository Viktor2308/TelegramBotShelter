package com.example.telegrambotshelter.mappers.cat;


import com.example.telegrambotshelter.db.entity.Cat;
import com.example.telegrambotshelter.dto.CatCreationDTO;
import com.example.telegrambotshelter.dto.CatDTO;
import org.springframework.stereotype.Component;

@Component
public class CatMapper {

    public Cat fromDTO(CatCreationDTO catCreationDTO) {
        return new Cat(
                catCreationDTO.getBreed(),
                catCreationDTO.getCatName(),
                Integer.parseInt(catCreationDTO.getYearOfBirthday()),
                catCreationDTO.getDescription()
        );
    }

    public CatDTO toDTO(Cat cat) {
        return new CatDTO(
                Long.toString(cat.getId()),
                cat.getBreed(),
                cat.getCatName(),
                Integer.toString(cat.getYearOfBirthday()),
                cat.getDescription()
        );
    }
}