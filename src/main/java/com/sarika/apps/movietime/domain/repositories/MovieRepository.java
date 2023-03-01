package com.sarika.apps.movietime.domain.repositories;

import com.sarika.apps.movietime.domain.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Override
    Movie save( Movie movie);

    @Override
    Optional<Movie> findById(Integer integer);

    @Query(value = """
    select m from Movie m 
    where m.movieId in (
    select mr.movieId from MovieRelease mr 
    where mr.startDate <= current_date() 
    and mr.endDate >= current_date()
    )"""
    )
    List<Movie> findRunningMovies();
}
