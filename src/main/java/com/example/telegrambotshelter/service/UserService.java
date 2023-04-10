package com.example.telegrambotshelter.service;

import com.example.telegrambotshelter.entity.User;
import com.example.telegrambotshelter.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User getUserByChatId(long chatId) {
        return userRepository.findByChatId(chatId);
    }

}
