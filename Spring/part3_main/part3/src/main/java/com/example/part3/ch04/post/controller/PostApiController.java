package com.example.part3.ch04.post.controller;


import com.example.part3.ch04.post.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post( @RequestBody Map<String,Object> requestData){

        requestData.entrySet().forEach(stringObjectEntry -> {
            System.out.println("key :" +stringObjectEntry.getKey());
            System.out.println("value : "+ stringObjectEntry.getValue());

        });


    }
    @PostMapping("/post02")
    public void post02(@RequestBody PostRequestDto requestData) {

        System.out.println(requestData.toString());

    }

}
