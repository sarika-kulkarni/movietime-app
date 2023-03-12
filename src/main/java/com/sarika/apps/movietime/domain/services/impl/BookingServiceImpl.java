package com.sarika.apps.movietime.domain.services.impl;

import com.sarika.apps.movietime.domain.entities.BookedSeat;
import com.sarika.apps.movietime.domain.entities.Booking;
import com.sarika.apps.movietime.domain.entities.MovieShow;
import com.sarika.apps.movietime.domain.exceptions.MovieShowNotFoundException;
import com.sarika.apps.movietime.domain.repositories.BookingRepository;
import com.sarika.apps.movietime.domain.repositories.MovieShowRepository;
import com.sarika.apps.movietime.domain.services.BookingService;
import com.sarika.apps.movietime.domain.vo.BookingRequest;
import com.sarika.apps.movietime.domain.vo.MovieShowAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public MovieShowAvailability getMovieShowAvailability(Integer movieShowId, Date movieShowDate) {
        MovieShowAvailability movieShowAvailability = new MovieShowAvailability();
        Optional<MovieShow> movieShow = movieShowRepository.findById(movieShowId);

        if(movieShow.isEmpty()){
            throw new MovieShowNotFoundException();
        }

        List<Booking> bookings = bookingRepository.findByMovieShow(movieShowId, movieShowDate);

        movieShowAvailability.setMovieShowDate(movieShowDate);
        movieShowAvailability.setNumberOfRows(movieShow.get().getAuditorium().getNumberOfRows());
        movieShowAvailability.setNumberOfSeatsPerRow(movieShow.get().getAuditorium().getNumberOfSeatsPerRow());

        if(!bookings.isEmpty()){
            for (Booking booking: bookings) {
                movieShowAvailability.getBookedSeats().addAll(booking.getSeats());
            }
        }

        return movieShowAvailability;
    }

    @Override
    public Booking bookShow(String userId, Integer movieShowId, BookingRequest bookingRequest) {
        Optional<MovieShow> movieShow = movieShowRepository.findById(movieShowId);
        Booking booking = new Booking();
        booking.setBookingDate(bookingRequest.getMovieShowDate());
        booking.setMovieShow(movieShow.get());
        booking.setEmail(userId);
        booking.setChildTickets(bookingRequest.getNumberOfChildTickets());
        booking.setAdultTickets(bookingRequest.getNumberOfAdultTickets());

        for (BookedSeat requestedSeat : bookingRequest.getRequestedSeats()) {
            requestedSeat.setBooking(booking);
        }

        booking.setSeats(bookingRequest.getRequestedSeats());

        bookingRepository.saveAndFlush(booking);

        return booking;
    }
}
