package com.example.part3_practice.ch04.get.controller;

import com.example.part3_practice.ch04.get.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path="/hello")
    public String hello(){
        return "get hello";
    }

    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name="id") String pathName){
        System.out.println("pathVariable : "+pathName);
        return  pathName;
    }

    //search?q=intellij
    // &oq=intellij
    // &aqs=chrome..69i57j69i59l3j0i512l2j0i433i512j0i512l3.4589j0j15
    // &sourceid=chrome
    // &ie=UTF-8

    @GetMapping("/query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(
                entry->{
                    System.out.println(entry.getKey());
                    System.out.println(entry.getValue());
                    System.out.println();

                    sb.append(entry.getKey() + "="+ entry.getValue() +"\n");
                });

                return sb.toString();

    }

    @GetMapping("/query-param02")
    public String queryParam2(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam int age){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name + " "+email +" "+age;
    }

    @GetMapping("/query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
