package com.sarika.apps.movietime.domain.exceptions;

public class MovieShowNotFoundException extends RuntimeException{

    private static final String message = "Movie show not found";

    public MovieShowNotFoundException(){
        super(message);
    }
}
