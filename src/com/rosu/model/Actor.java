package com.rosu.model;

public class Actor {
    private int id_pk_ai;
    private String first_name;
    private String last_name;
    private String gender;
    private int film_count;

    public Actor(int id_pk_ai, String first_name, String last_name, String gender, int film_count) {
        this.id_pk_ai = id_pk_ai;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.film_count = film_count;
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
