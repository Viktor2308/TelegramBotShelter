package com.example.telegrambotshelter.service;

import java.util.List;

public interface ControllerService<T,K> {

    T getById(long id);

    T create(K k);

    T update(String id, T t);

    List<T> getAll(T t);

    void delete(String id);
}
