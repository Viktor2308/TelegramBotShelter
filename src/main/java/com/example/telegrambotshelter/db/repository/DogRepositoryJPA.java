package com.example.telegrambotshelter.db.repository;

import com.example.telegrambotshelter.db.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepositoryJPA extends JpaRepository<Dog,Long> {
}
