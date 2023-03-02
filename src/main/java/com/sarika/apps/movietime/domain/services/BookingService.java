package com.sarika.apps.movietime.domain.services;

import com.sarika.apps.movietime.domain.vo.MovieShowAvailability;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface BookingService {
    MovieShowAvailability getMovieShowAvailability(Integer movieId, Integer movieShowId, Date movieShowDate);
}
