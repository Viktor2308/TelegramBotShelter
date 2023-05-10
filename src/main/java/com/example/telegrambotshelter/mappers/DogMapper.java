package com.example.telegrambotshelter.mappers;


import com.example.telegrambotshelter.db.entity.Dog;
import com.example.telegrambotshelter.dto.DogCreationDTO;
import com.example.telegrambotshelter.dto.DogDTO;
import org.springframework.stereotype.Component;

@Component
public class DogMapper {

    public Dog fromDTO(DogCreationDTO dogCreationDTO) {
        return new Dog(
                dogCreationDTO.getBreed(),
                dogCreationDTO.getDogName(),
                Integer.parseInt(dogCreationDTO.getYearOfBirthday()),
                dogCreationDTO.getDescription()
        );
    }

    public DogDTO toDTO(Dog dog) {
        return new DogDTO(
                Long.toString(dog.getId()),
                dog.getBreed(),
                dog.getDogName(),
                Integer.toString(dog.getYearOfBirthday()),
                dog.getDescription()
        );
    }
}