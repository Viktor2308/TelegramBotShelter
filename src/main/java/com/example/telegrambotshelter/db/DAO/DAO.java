package com.example.telegrambotshelter.db.DAO;

import java.util.List;

public interface DAO<T> {

    T add(T t);

    T getById(long id);

    List<T> getAll();

    void update(T t, long id);

    void delete(T t);
}
