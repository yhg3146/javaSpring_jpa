package com.example.part3_practice.ch08.calculator;

public class Calculator {
    private ICalculaotor iCalculaotor;

    public Calculator(ICalculaotor iCalculaotor){
        this.iCalculaotor = iCalculaotor;
    }

    public int sum(int x,int y){
        return iCalculaotor.sum(x,y);
    }


    public int minus(int x,int y){
        return iCalculaotor.minus(x,y);
    }
}
