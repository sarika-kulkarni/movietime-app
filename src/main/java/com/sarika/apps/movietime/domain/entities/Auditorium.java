package com.sarika.apps.movietime.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Auditorium")
@Getter
@Setter
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditorium_id")
    private int auditoriumId;
    @Column(name = "theater_id")
    private int theaterId;
    @Column(name = "Capacity")
    private int capacity;
    @Column(name = "Num_Rows")
    private  int numberOfRows;
    @Column(name = "Num_seats_per_row")
    private int numberOfSeatsPerRow;
}
