package com.sarika.apps.movietime.api;

import com.sarika.apps.movietime.domain.entities.MovieShow;
import com.sarika.apps.movietime.domain.repositories.MovieShowRepository;
import com.sarika.apps.movietime.domain.services.BookingService;
import com.sarika.apps.movietime.domain.vo.MovieShowAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movies/{movieId}/movieShows")
public class MovieShowController {

    private MovieShowRepository movieShowRepository;
    private BookingService bookingService;

    @Autowired
    public MovieShowController(MovieShowRepository movieShowRepository, BookingService bookingService){
        this.movieShowRepository = movieShowRepository;
        this.bookingService = bookingService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MovieShow>> getShowsForMovie(@PathVariable(name = "movieId") Integer movieId){
        List<MovieShow> movieShows = movieShowRepository.findMovieShowsByMovie(movieId);
        return ResponseEntity.ok(movieShows);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{movieShowId}/availability")
    public ResponseEntity<MovieShowAvailability> getAvailability(
            @PathVariable(name = "movieId") Integer movieId,
            @PathVariable(name = "movieShowId") Integer movieShowId,
            @RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date movieShowDate){

        MovieShowAvailability movieShowAvailability = bookingService.getMovieShowAvailability(
                movieId,
                movieShowId,
                movieShowDate);

        return ResponseEntity.ok(movieShowAvailability);
    }
}