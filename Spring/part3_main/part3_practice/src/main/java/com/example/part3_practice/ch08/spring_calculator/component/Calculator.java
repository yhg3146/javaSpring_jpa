package com.example.part3_practice.ch08.spring_calculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Calculator {

    private final ICalculaotor iCalculaotor;


    public int sum(int x,int y){
        this.iCalculaotor.init();
        return iCalculaotor.sum(x,y);
    }


    public int minus(int x,int y){

        this.iCalculaotor.init();
        return iCalculaotor.minus(x,y);
    }
}
