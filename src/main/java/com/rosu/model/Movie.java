package com.rosu.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pk_ai;

    private String name;
    private int year;
    private double ranks;

    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors = new HashSet<>();

    public Movie(int id_pk_ai, String name, int year, double ranks) {
        this.id_pk_ai = id_pk_ai;
        this.name = name;
        this.year = year;
        this.ranks = ranks;
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
    public double getRanks() {
        return ranks;
    }
    public void setRanks(double ranks) {
        this.ranks = ranks;
    }
}
