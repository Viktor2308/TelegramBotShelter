package com.example.telegrambotshelter.db.DAO;

import com.example.telegrambotshelter.db.entity.Cat;
import com.example.telegrambotshelter.db.repository.CatRepositoryJPA;
import com.example.telegrambotshelter.exeption.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
                () -> new ResourceNotFoundException("Cat with id " + id + " not found"));
    }

    @Override
    public List<Cat> getAll() {
        return catRepositoryJPA.findAll();
    }

    @Override
    public Cat update(Cat cat, long id) {
        if (catRepositoryJPA.existsById(id)) {
            catRepositoryJPA.update(
                    cat.getBreed(),
                    cat.getCatName(),
                    cat.getYearOfBirthday(),
                    cat.getDescription(),
                    id);
        }
        return catRepositoryJPA.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cat with id " + id + " not found"));
    }

    @Override
    public void delete(long id) {
        catRepositoryJPA.deleteById(id);
    }
}
