package com.sarika.apps.movietime.api;

import com.sarika.apps.movietime.domain.entities.Movie;
import com.sarika.apps.movietime.domain.repositories.MovieRepository;
import com.sarika.apps.movietime.domain.repositories.MovieShowRepository;
import com.sarika.apps.movietime.domain.vo.MovieShowDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movies")
@Slf4j
public class MovieController {

    private MovieRepository movieRepository;
    private MovieShowRepository movieShowRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository, MovieShowRepository movieShowRepository){
        this.movieRepository = movieRepository;
        this.movieShowRepository = movieShowRepository;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void addMovie(@RequestBody Movie movie){
        movieRepository.save(movie);
        log.info("Movie saved successfully");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Integer id){
        Optional<Movie> movie =  movieRepository.findById(id);

        if(movie.isPresent()){
            return ResponseEntity.ok(movie.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> findMovies(@RequestParam("running") boolean running){
        List<Movie> runningMovies = movieRepository.findRunningMovies();
        return ResponseEntity.ok(runningMovies);
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{id}/movieShows")
    public ResponseEntity<List<MovieShowDetails>> getMovieShows(@PathVariable("id") Integer movieId){
        Optional<Movie> movie =  movieRepository.findById(movieId);

        if(movie.isPresent()){
            List<MovieShowDetails> movieShows = movie.get().getTheaters().stream()
                    .map(theater -> new MovieShowDetails(movieId, theater))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(movieShows);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
