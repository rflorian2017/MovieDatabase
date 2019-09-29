package com.rosu.model;

public class Movies_genres {
    private int movieId;
    private String genre;

    public Movies_genres(int movieId, String genre) {
        this.movieId = movieId;
        this.genre = genre;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
