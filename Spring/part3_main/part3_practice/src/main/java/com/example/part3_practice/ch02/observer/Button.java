package com.example.part3_practice.ch02.observer;

public class Button {

    String name;
    IButtonListener buttonListener;

    public Button(String name){
        this.name=name;
    }


    public void addListener(IButtonListener buttonListener){
        this.buttonListener=buttonListener;
    }

    public void click(String message){
        buttonListener.clickEvent(message);
    }


}
