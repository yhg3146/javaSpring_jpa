package com.example.part3.ch04.get.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //REST API 처리하는 Controller
@RequestMapping("/api") //RequestMapping URI를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello")// thhp://localhost:9090/api/hello
    public String hello(){
        return "hello spring boot!";
    }


}
