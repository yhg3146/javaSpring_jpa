package com.example.part3.ch04.object_mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("--------");

        // Test JSON -> Object
        // Object -> Text Json

        //controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        //object -> text
        //obect mapper get method
        var user = new User("steve",10,"010-1111-2222");
        var text = objectMapper.writeValueAsString(user);

        System.out.println(text);

        // text -> object
        // Object mapper는 default 생성자를 필요로 한다.
        var objectUser = objectMapper.readValue(text,User.class);
        System.out.println(objectUser);
    }
}
