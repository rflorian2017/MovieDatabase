package com.rosu.repository;

import com.rosu.model.Actor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ActorRepository implements CrudRepository<Actor, Integer> {
    private EntityManager entityManager;

    public ActorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Actor> findById(Integer id) {
        Actor actor = entityManager.find(Actor.class, id);

        return actor == null ? Optional.empty() : Optional.of(actor);
    }

    @Override
    public List<Actor> findAll() {
        return entityManager.createQuery("SELECT a from Actor a").getResultList();
    }

    @Override
    public Optional<Actor> save(Actor actor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(actor);
            entityManager.getTransaction().commit();
            return Optional.of(actor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Actor deleteById(Integer id) {
        // try to find the entity in database
        Actor actor = entityManager.find(Actor.class, id);
        try {
            entityManager.getTransaction().begin();

            entityManager.remove(actor);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return actor;
    }

    /**
     *
     * @param name last Name of actor
     */
    public void deleteByName(String name) {
        //entityManager.createQuery("SELECT a from Actor a").getResultList();
        // DELETE a from Actor a WHERE a.last_name = name
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE from Actor a WHERE a.last_name = :name")
                    .setParameter("name", name)
                    .executeUpdate();

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Actor> findByName(String name) {

        List<Actor> actors = entityManager.createNamedQuery("Actor.findByName", Actor.class)
                .setParameter("name", name)
                .getResultList();

        return actors;

    }
}
