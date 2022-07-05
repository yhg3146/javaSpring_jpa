package com.example.part3_practice.ch02.adaptor;

public class Cleaner implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("클리너 220V on");
    }
}
