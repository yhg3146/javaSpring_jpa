package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/server")
@Slf4j
public class ServerController {

    @GetMapping("/naver")
    public String naver(){
        String query="갈비집";

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/blog.json")
                .queryParam("query",query)
                .queryParam("display",10)
                .queryParam("start",1)
                .queryParam("sort","sim")
                .encode()
                .build()
                .toUri();

        log.info("{}",uri);

        RequestEntity<Void> requestEntity = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id","PwrwTFSd0QN3B12ELU1l")
                .header("X-Naver-Client-Secret","o6JLBmVD6A")
                .build();


        RestTemplate restTemplate =new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(requestEntity,String.class);

        log.info("{}",response.getHeaders());
        log.info("{}",response.getBody());
        return response.getBody();


    }

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age){
        User user =new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post(
                    @RequestHeader("x-authorization") String authorization,
                    @RequestHeader("custom-header") String custom,
                    @RequestBody Req<User> user,
                     @PathVariable int userId,
                     @PathVariable String userName){

        log.info("authorization : {}, custom : {}",authorization,custom);
        log.info("userId : {}, userName : {}",userId,userName);
        log.info("user: {}",user);
        Req<User> req = new Req<>();

        req.setHeader(
                new Req.Header()
        );

        req.setResBody(user.getResBody());
        return req;
    }
}
