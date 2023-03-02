package com.sarika.apps.movietime.domain.repositories;

import com.sarika.apps.movietime.domain.entities.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Integer> {

    @Override
    Optional<MovieShow> findById(Integer integer);

    @Query(value = "from MovieShow ms where ms.movie.movieId = ?1")
    List<MovieShow> findMovieShowsByMovie(Integer movieId);

    @Query(value = "from MovieShow ms where ms.theater.theaterId = ?1")
    List<MovieShow> findMovieShowsByTheater(Integer theaterId);
}
