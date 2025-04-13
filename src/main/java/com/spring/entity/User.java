package com.spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class User{

    private int id;
    private String firstname;
    private String lastname;
    private String ssn;

}
