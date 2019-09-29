package com.rosu.model;

public class Actors {
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private int film_count;

    public Actors(int id, String first_name, String last_name, String gender, int film_count) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.film_count = film_count;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId() {
        return id;
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
