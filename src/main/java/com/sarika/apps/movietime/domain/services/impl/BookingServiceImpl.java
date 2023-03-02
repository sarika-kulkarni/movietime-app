package com.sarika.apps.movietime.domain.services.impl;

import com.sarika.apps.movietime.domain.entities.Booking;
import com.sarika.apps.movietime.domain.entities.MovieShow;
import com.sarika.apps.movietime.domain.exceptions.MovieShowNotFoundException;
import com.sarika.apps.movietime.domain.repositories.BookingRepository;
import com.sarika.apps.movietime.domain.repositories.MovieShowRepository;
import com.sarika.apps.movietime.domain.services.BookingService;
import com.sarika.apps.movietime.domain.vo.MovieShowAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingServiceImpl implements BookingService {

    private MovieShowRepository movieShowRepository;
    private BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(MovieShowRepository movieShowRepository, BookingRepository bookingRepository){
        this.movieShowRepository = movieShowRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public MovieShowAvailability getMovieShowAvailability(Integer movieId, Integer movieShowId, Date movieShowDate) {
        MovieShowAvailability movieShowAvailability = new MovieShowAvailability();
        Optional<MovieShow> movieShow = movieShowRepository.findById(movieShowId);

        if(movieShow.isEmpty()){
            throw new MovieShowNotFoundException();
        }

        List<Booking> bookings = bookingRepository.findByMovieShow(movieShowId);

        if(bookings.isEmpty()){
            movieShowAvailability.setMovieShowDate(movieShowDate);
            movieShowAvailability.setNumberOfRows(movieShow.get().getAuditorium().getNumberOfRows());
            movieShowAvailability.setNumberOfSeatsPerRow(movieShow.get().getAuditorium().getNumberOfSeatsPerRow());
            movieShowAvailability.setBookedSeats(Collections.EMPTY_MAP);
        }

        return movieShowAvailability;
    }
}
