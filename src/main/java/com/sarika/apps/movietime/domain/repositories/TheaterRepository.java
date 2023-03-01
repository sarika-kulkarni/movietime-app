package com.sarika.apps.movietime.domain.repositories;

import com.sarika.apps.movietime.domain.entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {

    @Override
    Theater save(Theater theater);

    Optional<Theater> findById(Integer integer);

    @Query(value = "select t from Theater t where t.zip = ?1")
    List<Theater> findByZip(String zip);
}
