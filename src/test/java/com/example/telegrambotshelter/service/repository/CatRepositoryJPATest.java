package com.example.telegrambotshelter.service.repository;

import com.example.telegrambotshelter.db.entity.Cat;
import com.example.telegrambotshelter.db.repository.CatRepositoryJPA;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA repository for work with entity cat")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CatRepositoryJPATest {

    @Autowired
    private CatRepositoryJPA catRepositoryJPA;

    @DisplayName("JUnit test for save cat operation")
    @Test
    void catShouldBeSaved() {
        Cat savedCat = catRepositoryJPA.save(new Cat("TestBreed", "TestName", 2020, "Test"));
        assertThat(savedCat).isNotNull();
    }

    @DisplayName("JUnit test should find no cats if repository is empty")
    @Test
    public void shouldFindNoCatsIfRepositoryIsEmpty() {
        List<Cat> cats = catRepositoryJPA.findAll();
        assertThat(cats).isEmpty();
    }

    @Test
    void update() {
    }

}