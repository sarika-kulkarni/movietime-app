package com.sarika.apps.movietime.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sarika.apps.movietime.domain.entities.BookedSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BookingRequest {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date movieShowDate;
    private int numberOfAdultTickets;
    private int numberOfChildTickets;
    private List<BookedSeat> requestedSeats;
}
