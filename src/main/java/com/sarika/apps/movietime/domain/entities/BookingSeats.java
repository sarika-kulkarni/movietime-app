package com.sarika.apps.movietime.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="booking_seats")
@IdClass(BookingSeatsId.class)
@Getter
@Setter
public class BookingSeats {
    @Id
    @Column(name = "booking_id")
    private Integer bookingId;

    @Id
    @Column(name = "seat_number")
    private int seatNumber;
}
