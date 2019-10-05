package com.rosu.repository;

import com.rosu.model.Movie;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class MovieRepository implements CrudRepository<Movie, Integer> {
    private EntityManager entityManager;

    public MovieRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public Optional<Movie> save(Movie movie) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(movie);
            entityManager.getTransaction().commit();
            return Optional.of(movie);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Movie deleteById(Integer id) {
        return null;
    }
}
