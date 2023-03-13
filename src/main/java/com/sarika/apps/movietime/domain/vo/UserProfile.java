package com.sarika.apps.movietime.domain.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String phone;
}
