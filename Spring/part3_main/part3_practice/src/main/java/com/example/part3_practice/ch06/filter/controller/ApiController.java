package com.example.part3_practice.ch06.filter.controller;


import com.example.part3_practice.ch06.filter.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class ApiController {

    @PostMapping("")
    public User user(@RequestBody User user){
        log.info("User :{}",user);
        return user;
    }




}
