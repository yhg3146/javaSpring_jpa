package com.example.part3_practice.ch06.interceptor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
@Slf4j
public class publicController {

    @GetMapping("/hello")
    public String hello(){
        return "public hello";
    }
}
