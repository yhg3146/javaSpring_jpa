package com.example.part3.ch02.singleton;

public class BClazz {

    private SocketClient socketClient;

    public BClazz(){
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
