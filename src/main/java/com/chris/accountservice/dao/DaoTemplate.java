package com.chris.accountservice.dao;

import java.util.List;
import java.util.Optional;

public interface DaoTemplate<T> {
    List<T> get();

    Optional<T> getById(Long id);

    T save(T item) throws IllegalArgumentException;

    T update(T item) throws IllegalArgumentException;

    int delete(Long id);

}
