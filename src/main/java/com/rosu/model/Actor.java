package com.rosu.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@NamedQueries(
        {
                @NamedQuery(
                        name = "Actor.findByName",
                        query = "SELECT a from Actor a where a.last_name = :name" //JPQL syntax
                )
        }
)
public class Actor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pk_ai;

    private String first_name;
    private String last_name;
    private String gender;
    private int film_count;


    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "actors_movies",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movies = new HashSet<>();

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Actor(int id_pk_ai, String first_name, String last_name, String gender, int film_count) {
        this.id_pk_ai = id_pk_ai;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.film_count = film_count;
    }

    public Actor() {

    }

    @Override
    public String toString() {
        return this.first_name + " " + this.last_name;
    }

    public void setId_pk_ai(int id_pk_ai) {
        this.id_pk_ai = id_pk_ai;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFilm_count(int film_count) {
        this.film_count = film_count;
    }

    public int getId_pk_ai() {
        return id_pk_ai;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public int getFilm_count() {
        return film_count;
    }
}
