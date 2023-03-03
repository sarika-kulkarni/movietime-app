package com.sarika.apps.movietime.domain.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
}
