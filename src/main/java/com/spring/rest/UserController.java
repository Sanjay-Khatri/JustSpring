package com.spring.rest;

import com.spring.domain.UserRequest;
import com.spring.domain.UserResponse;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Environment environment;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getTest(){
        return "UserController working...";
    }

    @GetMapping("/env")
    public String getEnvironment(){
        return environment.toString();
    }

    @GetMapping(value = "/get", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse getUser(@RequestParam(required = false, name="id") Optional<Integer> id, @RequestParam(required = false, name = "name") Optional<String> name){

        if(id.isPresent() && name.isPresent())
            return userService.getUserByIdAndName(id.get(), name.get());
        else if(id.isPresent())
            return userService.getUserById(id.get());
        else
            return userService.getUserByName(name.get());
    }

    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse createUser(@Valid @RequestBody UserRequest request){
        return userService.createUser(request);
    }

    @GetMapping(value = "/sample", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse getSample(){
            return userService.getUserSample();
    }
}
