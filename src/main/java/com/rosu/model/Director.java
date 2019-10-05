package com.rosu.model;

import javax.persistence.*;

@Entity
@Table
public class Director {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pk_ai;

    private String first_name;
    private String last_name;

    public Director(int id_pk_ai, String first_name, String last_name) {
        this.id_pk_ai = id_pk_ai;
        this.first_name = first_name;
        this.last_name = last_name;
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

    public void setId_pk_ai(int id_pk_ai) {
        this.id_pk_ai = id_pk_ai;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
