package com.example.telegrambotshelter.db.repository;

import com.example.telegrambotshelter.db.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DogRepositoryJPA extends JpaRepository<Dog, Long> {

    @Override
    Dog save(Dog dog);

    @Override
    List<Dog> findAll();

    @Transactional
    @Modifying
    @Query("update Dog dog set dog.breed = :breed, dog.dogName= :dogName, dog.yearOfBirthday = :yearOfBirthday, dog.description= :description where dog.id = :dogId")
    void update(@Param("breed") String breed, @Param("dogName") String dogName, @Param("yearOfBirthday") int yearOfBirthday, @Param("description") String description, @Param("dogId") long dogId);

}
