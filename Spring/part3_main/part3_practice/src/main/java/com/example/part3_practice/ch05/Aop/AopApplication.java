package com.example.part3_practice.ch05.Aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Base64;

@SpringBootApplication
public class AopApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class,args);
        System.out.println(Base64.getEncoder().encodeToString("steve@gmai.com".getBytes()));
    }
}
