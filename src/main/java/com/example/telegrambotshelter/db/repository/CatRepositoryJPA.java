package com.example.telegrambotshelter.db.repository;

import com.example.telegrambotshelter.db.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CatRepositoryJPA extends JpaRepository<Cat, Long> {

    @Override
    Cat save(Cat cat);

    @Override
    List<Cat> findAll();

    @Override
    boolean existsById(Long id);

    void deleteById(long id);

    @Transactional
    @Modifying
    @Query("update Cat cat set cat.breed = :breed, cat.catName= :catName, cat.yearOfBirthday = :yearOfBirthday, cat.description= :description where cat.id = :catId")
    void update(@Param("breed") String breed, @Param("catName") String catName, @Param("yearOfBirthday") int yearOfBirthday, @Param("description") String description, @Param("catId") long catId);

}
