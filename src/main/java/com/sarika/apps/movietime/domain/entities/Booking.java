package com.sarika.apps.movietime.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="booking")
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer bookingId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookingSeats> seats = new ArrayList<>();

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "movieshow_id")
    private MovieShow movieShow;

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "adult_tickets")
    private int adultTickets;

    @Column(name = "child_tickets")
    private int childTickets;
}
