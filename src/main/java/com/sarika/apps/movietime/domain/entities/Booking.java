package com.sarika.apps.movietime.domain.entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;
    @Column(name = "email")
    private String email;
    @Column(name = "movieshow_id")
    private int movieShowID;
    @Column(name = "booking_date")
    private Date bookingDate;
    @Column(name = "total_cost")
    private double totalCoast;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMovieShowID() {
        return movieShowID;
    }

    public void setMovieShowID(int movieShowID) {
        this.movieShowID = movieShowID;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getTotalCoast() {
        return totalCoast;
    }

    public void setTotalCoast(double totalCoast) {
        this.totalCoast = totalCoast;
    }
}
