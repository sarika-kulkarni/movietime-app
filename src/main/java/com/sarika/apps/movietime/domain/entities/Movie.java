package com.sarika.apps.movietime.domain.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Movie")
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;
    @Column(name = "Title")
    private String title;
    @Column(name = "Movie_Language")
    private String movieLanguage;
    @Column(name = "Director")
    private String director;
    @Column(name = "Genre")
    private String genre;
    @Column(name = "Release_Date")
    private Date releaseDate;
    @Column(name = "Duration")
    private int duration;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
        name = "movierelease",
        joinColumns = { @JoinColumn(name = "movie_id") },
        inverseJoinColumns = { @JoinColumn(name = "theater_id") }
    )
    @JsonIgnore
    private Set<Theater> theaters;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie", orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MovieShow> movieShows = new ArrayList<>();
}
