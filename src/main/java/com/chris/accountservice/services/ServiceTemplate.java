package com.chris.accountservice.services;

import java.util.Optional;
import java.util.Set;

public interface ServiceTemplate<T> {
    Set<T> findAll();

    Optional<T> findById(Long id);

    T save(T item);

    T update(T item);

    int delete(Long id);
}
