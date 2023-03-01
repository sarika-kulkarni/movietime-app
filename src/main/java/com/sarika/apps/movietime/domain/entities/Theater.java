package com.sarika.apps.movietime.domain.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="theater")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "theaterId"
)
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theater_id")
    private int theaterId;
    @Column(name = "theater_name")
    private String theaterName;
    @Column(name = "zip")
    private String zip;

    @ManyToMany(mappedBy = "theaters")
    private Set<Movie> movies;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theater", orphanRemoval = true)
    private List<MovieShow> movieShows = new ArrayList<>();

    public List<MovieShow> getMovieShows() {
        return movieShows;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
