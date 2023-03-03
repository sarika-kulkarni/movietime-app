package com.sarika.apps.movietime.domain.vo;

import com.sarika.apps.movietime.domain.entities.BookedSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MovieShowAvailability {
    private Date movieShowDate;
    private int numberOfRows;
    private int numberOfSeatsPerRow;
    private List<BookedSeat> bookedSeats;

    public MovieShowAvailability(){
        this.bookedSeats = new ArrayList<>();
    }
}
