package com.example.telegrambotshelter.db.DAO;

import com.example.telegrambotshelter.db.entity.User;
import com.example.telegrambotshelter.db.repository.UserRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@AllArgsConstructor
public class UserDAOImpl implements DAO<User> {

    private final UserRepositoryJPA userRepositoryJPA;

    @Override
    public User add(User user) {
        return userRepositoryJPA.save(user);
    }

    @Override
    public User getById(long id) {
        return userRepositoryJPA.findById(id).orElseThrow(
                () -> new ResolutionException("User with id " + id + " not found"));
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(User user, long id) {

    }

    @Override
    public void delete(User user) {

    }

    public boolean existsByChatId(long id){
        return userRepositoryJPA.existsByChatId(id);
    }
}
