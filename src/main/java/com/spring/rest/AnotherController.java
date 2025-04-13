package com.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnotherController {

    @GetMapping("/")
    public String getAnother(){
        return "Its working...";
    }

    @GetMapping("/example")
    public String getExample(){
        return "this is just an example...";
    }
}
