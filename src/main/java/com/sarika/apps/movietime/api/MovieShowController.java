package com.sarika.apps.movietime.api;

import com.sarika.apps.movietime.domain.entities.Booking;
import com.sarika.apps.movietime.domain.repositories.MovieShowRepository;
import com.sarika.apps.movietime.domain.services.BookingService;
import com.sarika.apps.movietime.domain.vo.BookingRequest;
import com.sarika.apps.movietime.domain.vo.MovieShowAvailability;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/movieShows")
@Slf4j
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
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Booking> bookMovieShow(
            @PathVariable(name = "movieShowId") Integer movieShowId,
            @RequestBody BookingRequest bookingRequest){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()){
            Booking booking = bookingService.bookShow(
                    ((UserDetails) authentication.getPrincipal()).getUsername(),
                    movieShowId,
                    bookingRequest);

            return ResponseEntity.ok(booking);
        }else{
            log.info("User not authenticated");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
