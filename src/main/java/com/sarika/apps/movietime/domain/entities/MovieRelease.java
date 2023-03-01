package com.sarika.apps.movietime.domain.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "movierelease")
@IdClass(MovieRelease.class)
public class MovieRelease {

    @Id
    @Column(name = "movie_id")
    private int movieId;

    @Id
    @Column(name = "theater_id")
    private int theaterId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

}
