package com.example.part3_practice.ch05.ioc_di2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IOCApplication {
    public static void main(String[] args) {
        SpringApplication.run(IOCApplication.class,args);
        ApplicationContext context = ApplicationContextProvider.getContext();
        Encoder encoder = context.getBean("urlEncode",Encoder.class);
        String url = "www.naver.com/book/it?page=10&size=spring-boot";
        String result =encoder.encode(url);
        System.out.println(result);




    }

    @Configuration
    class AppConfig{

        @Bean("base63Encode")
        public Encoder encoder(Base64Encoder base64Encoder){
            return new Encoder(base64Encoder);
        }

        @Bean("urlEncode")
        public Encoder urlEncoder(UrlEncoder urlEncoder){
            return new Encoder(urlEncoder);
        }


    }
}
