package com.sarika.apps.movietime.domain.repositories;

import com.sarika.apps.movietime.domain.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Override
    <S extends Booking> S saveAndFlush(S entity);

    @Query(value = "from Booking b where b.movieShow.movieShowId = ?1 and b.bookingDate = ?2")
    List<Booking> findByMovieShow(Integer movieShowId, Date bookingDate);
}
