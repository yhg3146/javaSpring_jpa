package com.example.part3_practice.ch02.decorator;

public class A3 extends AudiDecorator {
    public A3(ICar audi, String modelName) {
        super(audi, modelName, 1000);
    }
}
