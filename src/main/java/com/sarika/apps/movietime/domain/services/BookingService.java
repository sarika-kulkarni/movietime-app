package com.sarika.apps.movietime.domain.services;

import com.sarika.apps.movietime.domain.entities.Booking;
import com.sarika.apps.movietime.domain.vo.BookingRequest;
import com.sarika.apps.movietime.domain.vo.MovieShowAvailability;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface BookingService {
    MovieShowAvailability getMovieShowAvailability(Integer movieShowId, Date movieShowDate);

    Booking bookShow(String userId, Integer movieShowId, BookingRequest bookingRequest);
}

