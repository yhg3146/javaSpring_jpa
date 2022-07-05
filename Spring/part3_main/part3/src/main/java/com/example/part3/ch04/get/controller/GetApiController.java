package com.example.part3.ch04.get.controller;

import com.example.part3.ch04.get.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path="/hello") //http://localhost:9090/api/get/hello
    public String hello(){
        return "get Hello";
    }

    @RequestMapping(path ="/hi",method = RequestMethod.GET) //get http://localhost:9090/api/get/hi
    public String hi(){
        return "hi";
    }

    //http://localhost:9090/api/get/pathVariable/{name}
    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name ="id") String pathName){
        System.out.println("PathVariable : " + pathName);
        return pathName;

    }

    //search?q=intellij
    // &oq=intellij
    // &aqs=chrome..69i57j69i59l3j0i512l2j0i433i512j0i512l3.4589j0j15
    // &sourceid=chrome
    // &ie=UTF-8

    //?key=value & key2=value2

    //http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){

        StringBuilder sb =new StringBuilder();

        queryParam.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + "=" + entry.getValue() +"\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age){

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name+" "+email+" "+age;
    }

    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){


        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }


}
