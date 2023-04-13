package com.example.telegrambotshelter.repository;

import com.example.telegrambotshelter.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog,Long> {
}
