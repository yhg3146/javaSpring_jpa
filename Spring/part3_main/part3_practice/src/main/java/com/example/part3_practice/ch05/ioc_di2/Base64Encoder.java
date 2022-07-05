package com.example.part3_practice.ch05.ioc_di2;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base64")
public class Base64Encoder implements IEncoder {

    @Override
    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
