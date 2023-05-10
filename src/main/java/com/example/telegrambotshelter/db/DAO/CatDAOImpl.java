package com.example.telegrambotshelter.db.DAO;

import com.example.telegrambotshelter.db.entity.Cat;
import com.example.telegrambotshelter.db.repository.CatRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@AllArgsConstructor
public class CatDAOImpl implements DAO<Cat> {

    private final CatRepositoryJPA catRepositoryJPA;

    @Override
    public Cat add(Cat cat) {
        return catRepositoryJPA.save(cat);
    }

    @Override
    public Cat getById(long id) {
        return catRepositoryJPA.findById(id).orElseThrow(
                () -> new ResolutionException("Cat with id " + id + " not found"));
    }

    @Override
    public List<Cat> getAll() {
        return null;
    }

    @Override
    public void update(Cat cat, long id) {
    }

    @Override
    public void delete(Cat cat) {
    }
}
