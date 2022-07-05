package com.example.part3_practice.ch02.strategy;

import java.util.Base64;

public class Base64Strategy implements EncodingStrategy{

    private String text;


    @Override
    public String encode(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }
}
