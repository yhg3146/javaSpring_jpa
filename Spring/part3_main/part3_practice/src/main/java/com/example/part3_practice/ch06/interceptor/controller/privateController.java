package com.example.part3_practice.ch06.interceptor.controller;

import com.example.part3_practice.ch06.interceptor.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
@Slf4j
@Auth
public class privateController {

    @GetMapping("/hello")
    public String hello(){
        log.info("private hello");
        return "private hello";
    }
}
