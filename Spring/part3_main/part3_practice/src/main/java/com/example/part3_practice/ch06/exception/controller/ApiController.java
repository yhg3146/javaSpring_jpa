package com.example.part3_practice.ch06.exception.controller;

import com.example.part3_practice.ch06.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/user")
@Validated
public class ApiController {

    @GetMapping("")
    public User get(
            @Size(min=2)
            @RequestParam String name,
            @NotNull
            @Min(1)
            @RequestParam Integer age){

        User user =new User();
        user.setName(name);
        user.setAge(age);

        int a= 10+age;
        return user;
    }


    @PostMapping("")
    public User user(@Valid @RequestBody User user){
        return user;
    }


}
