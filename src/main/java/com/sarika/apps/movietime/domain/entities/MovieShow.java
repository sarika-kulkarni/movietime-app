package com.sarika.apps.movietime.domain.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@Table(name="movieshow")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "movieShowId"
)
public class MovieShow {
    @Id
    @Column(name = "movieshow_id")
    private int movieShowId;

    @Column(name = "showtime")
    private String showTime;

    @Column(name = "auditorium_id")
    private int auditoriumId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    public Movie getMovie() {
        return movie;
    }

    public int getMovieShowId() {
        return movieShowId;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setMovieShowId(int movieShowId) {
        this.movieShowId = movieShowId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getAuditoriumId() {
        return auditoriumId;
    }

    public void setAuditoriumId(int auditoriumId) {
        this.auditoriumId = auditoriumId;
    }
}
