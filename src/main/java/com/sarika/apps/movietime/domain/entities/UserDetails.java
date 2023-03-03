package com.sarika.apps.movietime.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="User_details")
@Getter
@Setter
public class UserDetails {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "user_password")
    private String password;
    @Column(name = "isadmin")
    private boolean isAdmin;
}
