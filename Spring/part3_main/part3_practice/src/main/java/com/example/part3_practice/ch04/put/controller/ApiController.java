package com.example.part3_practice.ch04.put.controller;

import com.example.part3_practice.ch04.put.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PutMapping("/put/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable(name="userId") Long id){
        System.out.println(requestDto);
        System.out.println(id);
        return requestDto;

    }
}
