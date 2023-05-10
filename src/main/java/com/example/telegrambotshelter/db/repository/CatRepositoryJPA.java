package com.example.telegrambotshelter.db.repository;

import com.example.telegrambotshelter.db.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatRepositoryJPA extends JpaRepository<Cat, Long> {

    Cat save(Cat cat);

    List<Cat> findAll();

    @Modifying
    @Query("update Cat cat set cat.breed = ?1, cat.catName=?2, cat.yearOfBirthday = ?3, cat.description=?4 where cat.id = ?5")
    void update(String breed, String catName, int yearOfBirthday, String description, long catId);
}
