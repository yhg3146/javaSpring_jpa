package com.example.part3_practice.ch04.object_mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObjectMapperApplicationTest {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("-----------------------");


        // object -> text
        var objectMapper= new ObjectMapper();
        User user = new User("steve",10,"00011112222");

        var text =objectMapper.writeValueAsString(user);
        System.out.println(text);


        //text -> object
        var objectUser = objectMapper.readValue(text,User.class);
        System.out.println(objectUser);

    }
}
