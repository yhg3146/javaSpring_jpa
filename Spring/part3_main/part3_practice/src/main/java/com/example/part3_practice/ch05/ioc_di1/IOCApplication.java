package com.example.part3_practice.ch05.ioc_di1;

public class IOCApplication {
    public static void main(String[] args) {

        String url = "www.naver.com/book/it?page=10&size=spring-boot";

        //base64Encoding
        IEncoder base64encoder = new Base64Encoder();
        IEncoder urlEncoder = new UrlEncoder();


        String result = base64encoder.encode(url);
        System.out.println(result);

        result = urlEncoder.encode(url);
        System.out.println(result);

        Encoder encoder = new Encoder(base64encoder);
        result =encoder.encode(url);
        System.out.println(result);

    }
}
