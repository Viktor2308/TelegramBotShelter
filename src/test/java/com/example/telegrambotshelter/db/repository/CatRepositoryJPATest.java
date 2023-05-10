package com.example.telegrambotshelter.db.repository;

import com.example.telegrambotshelter.db.entity.Cat;
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
        assertThat(savedCat.getCatName()).isEqualTo("TestName");
    }

    @DisplayName("JUnit test should find all cats in repository")
    @Test
    public void shouldFindNoCatsIfRepositoryIsEmpty() {
        List<Cat> cats = catRepositoryJPA.findAll();
        assertThat(cats).isNotEmpty();
    }

    @DisplayName("JUnit test should update cat by ID")
    @Test
    void update() {
        catRepositoryJPA.update(
                "UpdateBreed",
                "UpdateName",
                2021,
                "UpdateTest",
                0);
        Cat testCat = catRepositoryJPA.getReferenceById(0L);
        assertThat(testCat.getBreed()).isEqualTo("UpdateBreed");
        assertThat(testCat.getCatName()).isEqualTo("UpdateName");
        assertThat(testCat.getDescription()).isEqualTo("UpdateTest");
    }

}