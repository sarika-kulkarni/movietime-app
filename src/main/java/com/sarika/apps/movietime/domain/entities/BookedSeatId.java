package com.sarika.apps.movietime.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class BookedSeatId implements Serializable {
    private Booking booking;
    private String seatRow;
    private int seatNumber;

    public BookedSeatId(){

    }

    public BookedSeatId(Booking booking, String seatRow, int seatNumber){
        this.booking = booking;
        this.seatNumber = seatNumber;
        this.seatRow = seatRow;
    }
}
