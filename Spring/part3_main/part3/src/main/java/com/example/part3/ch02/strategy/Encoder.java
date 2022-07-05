package com.example.part3.ch02.strategy;

public class Encoder {

    private EncodingStrategy encodingStrategy;

    public String getMessage(String message){
        return encodingStrategy.encode(message);
    }

    public void setEncodingStrategy(EncodingStrategy encodingStrategy){
        this.encodingStrategy =encodingStrategy;
    }
}
