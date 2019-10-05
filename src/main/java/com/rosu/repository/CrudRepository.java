package com.rosu.repository;

import java.util.List;

public interface CrudRepository<T,K> {
    T findById(K id);
    List<T> findAll();
    T save(T object);
    T delete(T object);
}
