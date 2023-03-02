package com.sarika.apps.movietime.api;

import com.sarika.apps.movietime.domain.entities.Movie;
import com.sarika.apps.movietime.domain.entities.MovieShow;
import com.sarika.apps.movietime.domain.repositories.MovieRepository;
import com.sarika.apps.movietime.domain.repositories.MovieShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
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
        System.out.println(movie);
        movieRepository.save(movie);
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

}
