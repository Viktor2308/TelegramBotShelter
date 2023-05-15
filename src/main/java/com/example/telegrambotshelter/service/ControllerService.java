package com.example.telegrambotshelter.service;

import java.util.List;

public interface ControllerService<T,K> {

    T getById(long id);

    T create(K k);

    T update(long id, K k);

    List<T> getAll();

    T delete(long id);
}
