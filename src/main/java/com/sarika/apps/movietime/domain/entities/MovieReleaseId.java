package com.sarika.apps.movietime.domain.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class MovieReleaseId {
    private int movieId;
    private int theaterId;
}
