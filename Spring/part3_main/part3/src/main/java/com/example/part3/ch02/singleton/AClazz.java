package com.example.part3.ch02.singleton;

public class AClazz {

    private SocketClient socketClient;

    public AClazz(){
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }



}
