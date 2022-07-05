package com.example.part3_practice.ch08.spring_calculator.controller;

import com.example.part3_practice.ch08.spring_calculator.component.Calculator;
import com.example.part3_practice.ch08.spring_calculator.dto.Req;
import com.example.part3_practice.ch08.spring_calculator.dto.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final Calculator calculator;
    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y){
        return calculator.sum(x,y);
    }

    @PostMapping("/minus")
    public Res minus(@RequestBody Req req)
    {
        int result = calculator.minus(req.getX(), req.getY());

        Res res =new Res();
        res.setResult(result);
        res.setResponse(
                new Res.Body()
        );

        return res;

    }
}
