package com.example.part3_practice.ch04.delete.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @DeleteMapping("/delete/{userId}")
    public void delete(@RequestParam String account, @PathVariable String userId){
        System.out.println(userId);
        System.out.println(account);

    }
}
