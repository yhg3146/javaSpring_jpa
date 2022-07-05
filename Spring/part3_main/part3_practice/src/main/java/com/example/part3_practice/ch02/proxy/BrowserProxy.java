package com.example.part3_practice.ch02.proxy;

public class BrowserProxy implements IBrowser{

    private String url;
    private Html html;

    public BrowserProxy(String url){
        this.url=url;
    }


    @Override
    public Html show() {
        if(html == null){
            html= new Html(url);
            System.out.println("BrowserProxy loading html from : "+url);
        }
        System.out.println("BrowserProxy use cache html from : "+url);
        return html;
    }
}
