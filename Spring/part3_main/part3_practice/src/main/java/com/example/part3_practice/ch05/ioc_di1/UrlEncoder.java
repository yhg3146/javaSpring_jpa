package com.example.part3_practice.ch05.ioc_di1;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncoder implements IEncoder{


    @Override
    public String encode(String message) {
        try {
            return URLEncoder.encode(message,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
