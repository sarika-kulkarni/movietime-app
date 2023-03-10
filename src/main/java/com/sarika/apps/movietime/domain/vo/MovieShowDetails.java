package com.sarika.apps.movietime.domain.vo;

import com.sarika.apps.movietime.domain.entities.MovieShow;
import com.sarika.apps.movietime.domain.entities.Theater;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MovieShowDetails {
    private Theater theater;
    private List<MovieShow> movieShows;

    public MovieShowDetails(Integer movieId, Theater theater){
        this.theater = theater;
        this.movieShows = theater.getMovieShows()
                .stream()
                .filter(show -> show.getMovie().getMovieId() == movieId)
                .collect(Collectors.toList());

    }
}
