package com.example.part3.ch02.observer;

public class Button {

    String name;
    IButtonListner buttonListner;

    public Button(String name){
        this.name =name;
    }

    public void click(String message){
        buttonListner.clickEvent(message);
    }

    public void addListener(IButtonListner buttonListner){
        this.buttonListner=buttonListner;
    }
}
