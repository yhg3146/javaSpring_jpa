package com.example.part3_practice.ch08.calculator;

public class KrwCalculator implements ICalculaotor{


    private int price =1;

    @Override
    public int sum(int x, int y) {
        return x+y;
    }

    @Override
    public int minus(int x, int y) {
        return x-y;
    }
}
