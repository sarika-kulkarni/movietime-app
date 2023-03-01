package com.sarika.apps.movietime.domain.entities;

import java.io.Serializable;

public class BookingSeatsId implements Serializable {
    private int bookingId;
    private int seatNumber;

    public BookingSeatsId(int bookingId, int seatNumber){
        this.bookingId = bookingId;
        this.seatNumber = seatNumber;
    }
}
