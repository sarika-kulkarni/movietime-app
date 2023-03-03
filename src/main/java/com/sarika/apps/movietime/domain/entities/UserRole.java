package com.sarika.apps.movietime.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_roles")
@IdClass(UserRoleId.class)
@Getter
@Setter
public class UserRole {

    @Id
    @ManyToOne
    @JoinColumn(name = "email")
    private User user;

    @Id
    private String role;
}
