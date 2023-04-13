package com.example.telegrambotshelter.repository;

import com.example.telegrambotshelter.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat,Long> {
}
