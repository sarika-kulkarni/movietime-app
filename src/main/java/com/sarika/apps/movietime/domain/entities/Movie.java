package com.sarika.apps.movietime.domain.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Movie")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "movieId"
)
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

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "movierelease",
        joinColumns = { @JoinColumn(name = "movie_id") },
        inverseJoinColumns = { @JoinColumn(name = "theater_id") }
    )
    private Set<Theater> theaters;

    public List<MovieShow> getMovieShows() {
        return movieShows;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie", orphanRemoval = true)
    private List<MovieShow> movieShows = new ArrayList<>();

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }
}
