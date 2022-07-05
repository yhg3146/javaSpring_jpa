package com.example.part3.ch05.AOP;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootApplication
public class AOPApplication {
    public static void main(String[] args) {
        SpringApplication.run(AOPApplication.class,args);
        System.out.println(Base64.getEncoder().encodeToString("steve@email.com".getBytes()));

    }
}
