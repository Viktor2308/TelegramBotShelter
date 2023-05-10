package com.example.telegrambotshelter.db.DAO;

import com.example.telegrambotshelter.db.entity.Dog;
import com.example.telegrambotshelter.db.repository.DogRepositoryJPA;
import com.example.telegrambotshelter.exeption.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DogDAOImpl implements DAO<Dog> {

    private final DogRepositoryJPA dogRepositoryJPA;

    @Override
    public Dog add(Dog dog) {
        return dogRepositoryJPA.save(dog);
    }

    @Override
    public Dog getById(long id) {
        return dogRepositoryJPA.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Dog with id " + id + " not found"));
    }

    @Override
    public List<Dog> getAll() {
        return null;
    }

    @Override
    public Dog update(Dog dog, long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
