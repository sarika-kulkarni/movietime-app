package com.sarika.apps.movietime.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Booking_seats")
@IdClass(BookingSeatsId.class)
public class BookingSeats {
    @Id
    @Column(name = "booking_id")
    private int bookingId;
    @Id
    @Column(name = "seat_number")
    private int seatNumber;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
