package com.example.telegrambotshelter.service.repositoryServiceImpl;

import com.example.telegrambotshelter.entity.Dog;
import com.example.telegrambotshelter.repository.DogRepository;
import com.example.telegrambotshelter.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DogService implements RepositoryService<Dog> {

    private final DogRepository dogRepository;

    @Override
    public void add(Dog dog) {
        dogRepository.save(dog);
    }

    @Override
    public Dog get(long id) {
        return dogRepository.findById(id).orElseThrow(
                () -> new ResolutionException("Dog with id " + id + " not found"));
    }

    @Override
    public List<Dog> getAll() {
        return null;
    }

    @Override
    public void update(Dog dog) {

    }

    @Override
    public void delete(Dog dog) {

    }
}
