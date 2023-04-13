package com.example.telegrambotshelter.service.repositoryServiceImpl;

import com.example.telegrambotshelter.entity.Cat;
import com.example.telegrambotshelter.repository.CatRepository;
import com.example.telegrambotshelter.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatService implements RepositoryService<Cat> {

    private final CatRepository catRepository;

    @Override
    public void add(Cat cat) {
        catRepository.save(cat);
    }

    @Override
    public Cat get(long id) {
        return catRepository.findById(id).orElseThrow(
                () -> new ResolutionException("Cat with id " + id + " not found"));
    }

    @Override
    public List<Cat> getAll() {
        return null;
    }

    @Override
    public void update(Cat cat) {

    }

    @Override
    public void delete(Cat cat) {

    }
}
