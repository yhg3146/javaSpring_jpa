package com.example.part3_practice.ch04.post.controller;

import com.example.part3_practice.ch04.post.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String,Object> requestData){
        requestData.entrySet().forEach(
                entry->{
                    System.out.println("key : "+entry.getKey());
                    System.out.println("value : " + entry.getValue());
                }
        );
    }

    @PostMapping("/post02")
    public void post02(@RequestBody PostRequestDto requestData){

        System.out.println(requestData.toString());

    }

}
