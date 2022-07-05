package com.example.part3_practice.ch06.async.controller;

import com.example.part3_practice.ch06.async.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
@Slf4j
public class AsyncController {

    public AsyncService asyncService;

    public AsyncController(AsyncService asyncService){
        this.asyncService=asyncService;
    }

    @GetMapping("/hello")
    public CompletableFuture hello(){
       log.info("method");
        return asyncService.run();
    }

}
