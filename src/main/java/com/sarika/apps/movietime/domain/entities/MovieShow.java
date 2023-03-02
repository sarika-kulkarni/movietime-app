package com.sarika.apps.movietime.domain.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="movieshow")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "movieShowId"
)
@Getter
@Setter
public class MovieShow {
    @Id
    @Column(name = "movieshow_id")
    private int movieShowId;

    @Column(name = "showtime")
    private String showTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "auditorium_id")
    private Auditorium auditorium;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @Column(name = "adult_ticket_price")
    private double adultTicketPrice;

    @Column(name = "child_ticket_price")
    private double childTicketPrice;
}
