package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class RestTemplateService {

    public UserResponse hello() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "steve")
                .queryParam("age", 10)
                .encode()
                .build()
                .toUri();

        log.info("uri : {}", uri);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);
        log.info("{}", result.getBody());
        log.info("{}", result.getStatusCode());
        return result.getBody();


    }

    public UserResponse post(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100,"aaaa")
                .toUri();

        log.info("{}",uri);


        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri,req,UserResponse.class);

        log.info("{}",response.getBody());
        log.info("{}",response.getStatusCode());

        return response.getBody();
    }

    public UserResponse exchange(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100,"aaaa")
                .toUri();

        log.info("uri : {}",uri);

        UserRequest req = new UserRequest("steve",10);

        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","abcd")
                .header("custom-header","ffffff")
                .body(req);

        RestTemplate restTemplate =new RestTemplate();

        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity,UserResponse.class);

        System.out.println(response.getBody());
        System.out.println(response.getHeaders());

        return response.getBody();

    }

    public Req<UserResponse> genericExchange(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100,"aaaa")
                .toUri();

        log.info("uri : {}",uri);

        UserRequest reqBody = new UserRequest("steve",10);

        Req<UserRequest> req = new Req<>();

        req.setHeader(
            new Req.Header()
        );

        req.setResBody(
                reqBody
        );
        log.info("reqBody : {} , req : {}",reqBody,req);
        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","authorization")
                .header("custom-header","custom-header")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Req<UserResponse>> response = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Req<UserResponse>>() {});

        log.info("{}",response.getBody());
        log.info("{}",response.getHeaders());

        return response.getBody();
    }


}
