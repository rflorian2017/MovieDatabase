package com.rosu.model;

public class Movie_directors {
    private int directorId;
    private int movieId;

    public Movie_directors(int directorId, int movieId) {
        this.directorId = directorId;
        this.movieId = movieId;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
