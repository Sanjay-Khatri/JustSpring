package com.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ExceptionResponse {

    private Date timestamp;
    private int status;
    private String message;

}
