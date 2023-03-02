package com.sarika.apps.movietime.domain.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class MovieShowAvailability {
    private Date movieShowDate;
    private int numberOfRows;
    private int numberOfSeatsPerRow;
    private Map<String, List<Integer>> bookedSeats;
}
