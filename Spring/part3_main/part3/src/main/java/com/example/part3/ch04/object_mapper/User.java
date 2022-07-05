package com.example.part3.ch04.object_mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private String name;
    private int age;
    @JsonProperty("phone_number")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User(){
        this.name=null;
        this.age=0;
        this.phoneNumber=null;
    }
    public User(String name,int age,String phoneNumber){
        this.name=name;
        this.age=age;
        this.phoneNumber=phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //get붙이면 안
    public User defaultUser(){
        return  new User("default",0,"010-1111-2222");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
