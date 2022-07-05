package com.example.part3.ch02.strategy;

public class AppendStrategy implements EncodingStrategy{
    @Override
    public String encode(String text) {
        return "ABCD"+text;
    }
}
