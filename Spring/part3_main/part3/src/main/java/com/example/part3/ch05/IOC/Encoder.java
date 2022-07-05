package com.example.part3.ch05.IOC;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class Encoder {
    private IEncoder iEncoder;
    public Encoder( IEncoder iEncoder){
        this.iEncoder=iEncoder;
    }
    public String encode(String message){

        return iEncoder.encode(message);
    }

    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder=iEncoder;
    }
}
