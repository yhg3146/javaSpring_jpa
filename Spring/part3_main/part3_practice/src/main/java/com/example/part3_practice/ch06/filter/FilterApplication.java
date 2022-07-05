package com.example.part3_practice.ch06.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.annotation.WebFilter;

@SpringBootApplication
@ServletComponentScan
public class FilterApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilterApplication.class,args);
    }
}
