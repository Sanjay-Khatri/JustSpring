package com.spring.domain;

import com.spring.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class UserResponse {

    private int id;
    private String firstname;
    private String lastname;
    private String ssn;
    private String message;


    public UserResponse(User user) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.ssn = user.getSsn();
        this.message = "This is just a random message for additional field.";
    }
}
