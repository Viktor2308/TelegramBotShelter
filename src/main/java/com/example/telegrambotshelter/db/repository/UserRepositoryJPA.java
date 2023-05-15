package com.example.telegrambotshelter.db.repository;

import com.example.telegrambotshelter.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJPA extends JpaRepository<User, Long> {

    boolean existsByChatId(long id);
}
