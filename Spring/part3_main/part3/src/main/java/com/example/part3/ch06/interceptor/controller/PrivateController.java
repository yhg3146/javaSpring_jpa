package com.example.part3.ch06.interceptor.controller;

import com.example.part3.ch06.interceptor.anotiation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
@Auth
@Slf4j
public class PrivateController {

    @GetMapping("/hello")
    public String hello(){
       log.info("private hello controller");
        return "private hello";
    }
}
