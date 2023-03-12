package com.sarika.apps.movietime.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="booked_seats")
@IdClass(BookedSeatId.class)
@Getter
@Setter
public class BookedSeat {
    @Id
    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonIgnore
    private Booking booking;

    @Id
    @Column(name = "seat_row")
    private String seatRow;

    @Id
    @Column(name = "seat_number")
    private int seatNumber;
}
