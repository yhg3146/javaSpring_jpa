package com.example.part3_practice.ch02;

import com.example.part3_practice.ch02.adaptor.*;
import com.example.part3_practice.ch02.decorator.*;
import com.example.part3_practice.ch02.facade.SftpClient;
import com.example.part3_practice.ch02.observer.Button;
import com.example.part3_practice.ch02.observer.IButtonListener;
import com.example.part3_practice.ch02.proxy.Browser;
import com.example.part3_practice.ch02.proxy.BrowserProxy;
import com.example.part3_practice.ch02.proxy.IBrowser;
import com.example.part3_practice.ch02.proxy_aop.AopBrowser;
import com.example.part3_practice.ch02.singleton.AClazz;
import com.example.part3_practice.ch02.singleton.BClazz;
import com.example.part3_practice.ch02.singleton.SocketClient;
import com.example.part3_practice.ch02.strategy.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {

   /*
   //singleton
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("둘이 같은 객체인가?");
        System.out.println(aClient.equals(bClient));

        */
/*
        //adaptor
        HairDryer hairDryer= new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        SocketAdaptor adaptor = new SocketAdaptor(cleaner);
        connect(adaptor);

        AirConditioner airConditioner = new AirConditioner();
        SocketAdaptor airAdapter = new SocketAdaptor(airConditioner);
        connect(airAdapter);





    }

    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }*/

        //proxy

        /*
        IBrowser browser =new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        */
/*

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                long now=System.currentTimeMillis();
                end.set(now-start.get());
                });

        aopBrowser.show();
        System.out.println("loading time : " + end.get());

        aopBrowser.show();
        System.out.println("loading time : " + end.get());

*/

/*
        //decorator
        ICar audi = new Audi(1000);
        audi.showPrice();

        ICar audi3 = new A3(audi,"A3");
        audi3.showPrice();

        ICar audi4 = new A4(audi,"A4");
        audi4.showPrice();

        ICar audi5 = new A5(audi,"A5");
        audi5.showPrice();
    */
/*
        //observer

        Button button = new Button("버튼");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String message) {
                System.out.println(message);
            }
        });

        button.click("메세지 전달 : click 1");
        button.click("메세지 전달 : click 2");
        button.click("메세지 전달 : click 3");
        button.click("메세지 전달 : click 4");
        button.click("메세지 전달 : click 5");

        */
/*
        //facade
        SftpClient sftpClient = new SftpClient("www.foo.co.kr",22,"home/etc","text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();*/

        //strategy

        Encode encode = new Encode();

        EncodingStrategy base64 = new Base64Strategy();
        EncodingStrategy normal = new NormalStrategy();

        String message ="hello java";

        encode.setEncodingStrategy(base64);
        System.out.println(encode.encode(message));

        encode.setEncodingStrategy(normal);
        System.out.println(encode.encode(message));

    }

}
