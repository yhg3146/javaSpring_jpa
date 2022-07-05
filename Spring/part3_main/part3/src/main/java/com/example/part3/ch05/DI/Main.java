package com.example.part3.ch05.DI;

public class Main {
    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        //Base64

        //url encoding
        Encoder encoder =new Encoder(new UrlEncoder());
        String result = encoder.encode(url);
        System.out.println(result);


    }
}
