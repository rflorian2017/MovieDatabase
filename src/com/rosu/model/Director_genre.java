package com.rosu.model;

public class Director_genre {
    private int director_id;
    private int movie_id;


    public Director_genre(int director_id, int movie_id) {
        this.director_id = director_id;
        this.movie_id = movie_id;
    }

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }
}
