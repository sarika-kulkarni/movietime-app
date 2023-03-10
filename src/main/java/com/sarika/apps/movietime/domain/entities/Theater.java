package com.sarika.apps.movietime.domain.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="theater")
@Getter
@Setter
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
    @JsonIgnore
    private Set<Movie> movies;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theater", orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MovieShow> movieShows = new ArrayList<>();
}
