package com.example.telegrambotshelter.service;

import java.util.List;
import java.util.Optional;

public interface RepositoryService<T> {

    void add(T t);

    T get(long id);

    List<T> getAll();

    void update(T t);

    void delete(T t);
}
