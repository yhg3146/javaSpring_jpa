package com.example.part3.ch02;

import com.example.part3.ch02.Proxy.Browser;
import com.example.part3.ch02.Proxy.BrowserProxy;
import com.example.part3.ch02.Proxy.IBrowser;
import com.example.part3.ch02.Proxy_aop.AopBrowser;
import com.example.part3.ch02.adaptor.*;
import com.example.part3.ch02.decorator.*;
import com.example.part3.ch02.facade.Ftp;
import com.example.part3.ch02.facade.Reader;
import com.example.part3.ch02.facade.SftpClient;
import com.example.part3.ch02.facade.Writer;
import com.example.part3.ch02.observer.Button;
import com.example.part3.ch02.observer.IButtonListner;
import com.example.part3.ch02.singleton.AClazz;
import com.example.part3.ch02.singleton.BClazz;
import com.example.part3.ch02.singleton.SocketClient;
import com.example.part3.ch02.strategy.*;
import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.atomic.AtomicLong;

public class main {
    public static void main(String[] args) {
/*
//        singleton

        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개의 개체가 동일한가?");
        System.out.println(aClient.equals(bClient));
*/

/*
        // adapter


        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);
    }

    //콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }*/

/*
//Proxy
        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });
        aopBrowser.show();
        System.out.println("loading time : " + end.get());

        aopBrowser.show();
        System.out.println("loading time : " + end.get());
    }*/
/*
    //Decorator

        ICar audi = new Audi(1000);
        audi.showPrice();

        //a3
        ICar audi3 = new A3(audi,"A3");
        audi3.showPrice();
        //a4
        ICar audi4 = new A4(audi,"A4");
        audi4.showPrice();
        //a5

        ICar audi5 = new A5(audi,"A5");
        audi5.showPrice();*/

      //observer
      Button button = new Button("버튼");
        button.addListener(new IButtonListner() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);

            }
        });

        button.click("메세지 전달 : click 1");
        button.click("메세지 전달 : click 2");
        button.click("메세지 전달 : click 3");
        button.click("메세지 전달 : click 4");
        button.click("메세지 전달 : click 5");
    }

       /*
       facade
       Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();
        System.out.println();
        SftpClient sftpClient = new SftpClient("www.foo.co.kr",22,"home/etc","text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();*/

        /*
        strategy
        Encoder encoder =new Encoder();
        EncodingStrategy base64 = new Base64Strategy();
        EncodingStrategy normal = new NormalStrategy();


        String message = "hello java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);*/

    }

