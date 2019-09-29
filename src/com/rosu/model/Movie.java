package com.rosu.model;

public class Movie {
    private int id_pk_ai;
    private String name;
    private int year;
    private double rank;
    public Movie(int id_pk_ai, String name, int year, double rank) {
        this.id_pk_ai = id_pk_ai;
        this.name = name;
        this.year = year;
        this.rank = rank;
    }
    public int getId_pk_ai() {
        return id_pk_ai;
    }
    public void setId_pk_ai(int id_pk_ai) {
        this.id_pk_ai = id_pk_ai;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public double getRank() {
        return rank;
    }
    public void setRank(double rank) {
        this.rank = rank;
    }
}
