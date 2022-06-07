package com.bean;

import javax.persistence.*;

@Entity
public class Director {

    @Id
    private int id;
    private String name;

    @OneToOne
    @JoinColumn(name = "id")
    private Movie movie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
