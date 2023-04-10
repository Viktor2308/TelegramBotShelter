package com.example.telegrambotshelter.repository;

import com.example.telegrambotshelter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByChatId(long chatId);
}
