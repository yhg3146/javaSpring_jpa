package com.example.part3_practice.ch08.calculator;

public class DollarCalculator implements ICalculaotor{

    private int price =1;

    private MarketApi marketApi;

    public DollarCalculator(MarketApi marketApi){
        this.marketApi=marketApi;
    }

    public void init(){
        this.price = marketApi.connect();
    }

    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x+y;
    }

    @Override
    public int minus(int x, int y) {
        x *= price;
        y *= price;
        return x-y;
    }
}
