package com.example.telegrambotshelter.service.repositoryServiceImpl;

import com.example.telegrambotshelter.entity.User;
import com.example.telegrambotshelter.repository.UserRepository;
import com.example.telegrambotshelter.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements RepositoryService<User> {

    private final UserRepository userRepository;


    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public User get(long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResolutionException("User with id " + id + " not found"));
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    public boolean existsByChatId(long id){
        return userRepository.existsByChatId(id);
    };
}
