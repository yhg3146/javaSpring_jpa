package com.example.part3_practice.ch02.adaptor;

public class HairDryer implements Electronic110V{
    @Override
    public void powerOn() {
        System.out.println("드라이어 110V on");
    }
}
