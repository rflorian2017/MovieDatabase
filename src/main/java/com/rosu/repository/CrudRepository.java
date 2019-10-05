package com.rosu.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T,K> {
    Optional<T> findById(K id);
    List<T> findAll();
    Optional<T> save(T object);
    T deleteById(K id);
}
