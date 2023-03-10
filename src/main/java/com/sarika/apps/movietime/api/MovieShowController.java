package com.sarika.apps.movietime.api;

import com.sarika.apps.movietime.domain.entities.Booking;
import com.sarika.apps.movietime.domain.repositories.MovieShowRepository;
import com.sarika.apps.movietime.domain.services.BookingService;
import com.sarika.apps.movietime.domain.vo.BookingRequest;
import com.sarika.apps.movietime.domain.vo.MovieShowAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/movieShows")
public class MovieShowController {

    private MovieShowRepository movieShowRepository;
    private BookingService bookingService;

    @Autowired
    public MovieShowController(MovieShowRepository movieShowRepository, BookingService bookingService){
        this.movieShowRepository = movieShowRepository;
        this.bookingService = bookingService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{movieShowId}/availability")
    public ResponseEntity<MovieShowAvailability> getAvailability(
            @PathVariable(name = "movieShowId") Integer movieShowId,
            @RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date movieShowDate){

        MovieShowAvailability movieShowAvailability = bookingService.getMovieShowAvailability(
                movieShowId,
                movieShowDate);

        return ResponseEntity.ok(movieShowAvailability);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/{movieShowId}/bookings",
            consumes = "application/json"
    )
    public ResponseEntity<Booking> bookMovieShow(
            @PathVariable(name = "movieShowId") Integer movieShowId,
            @RequestBody BookingRequest bookingRequest){

        Booking booking = bookingService.bookShow(
                movieShowId,
                bookingRequest);

        return ResponseEntity.ok(booking);
    }
}
