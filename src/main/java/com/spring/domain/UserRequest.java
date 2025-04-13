package com.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UserRequest {

    @NotBlank(message = "firstname cannot be empty")
    private String firstname;

    @NotBlank(message = "lastname cannot be empty")
    private String lastname;

    @NotBlank(message = "ssn cannot be empty")
    private String ssn;

}
