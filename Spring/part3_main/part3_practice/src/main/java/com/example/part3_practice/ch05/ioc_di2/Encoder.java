package com.example.part3_practice.ch05.ioc_di2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Encoder {

    private IEncoder iEncoder;

    public Encoder(@Qualifier("base64") IEncoder iEncoder){
        this.iEncoder=iEncoder;
    }
    public String encode(String message){
        return iEncoder.encode(message);
    }

    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }
}
