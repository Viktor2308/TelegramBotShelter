package com.example.telegrambotshelter.repository;

import com.example.telegrambotshelter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByChatId(long id);
}
