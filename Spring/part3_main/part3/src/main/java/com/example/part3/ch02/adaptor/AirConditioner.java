package com.example.part3.ch02.adaptor;

public class AirConditioner implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("에어컨 220V on");
    }
}
