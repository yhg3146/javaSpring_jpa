package com.example.part3_practice.ch02.strategy;

public class Encode {

    private String message;
    private EncodingStrategy encodingStrategy;

    public String encode(String message){
        return encodingStrategy.encode(message);
    }

    public void setEncodingStrategy(EncodingStrategy encodingStrategy){
        this.encodingStrategy=encodingStrategy;
    }
}
