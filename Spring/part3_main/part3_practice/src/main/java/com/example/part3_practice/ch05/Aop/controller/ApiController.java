package com.example.part3_practice.ch05.Aop.controller;

import com.example.part3_practice.ch05.Aop.annotation.Decode;
import com.example.part3_practice.ch05.Aop.annotation.Timer;
import com.example.part3_practice.ch05.Aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id,@RequestParam String name){
        System.out.println("get method");
        System.out.println("get method : "+id);
        System.out.println("get method : "+name);

        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
        System.out.println("post method : "+user);
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        Thread.sleep(2*1000);
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user){
        System.out.println("put method : "+user);
        return user;
    }
}
