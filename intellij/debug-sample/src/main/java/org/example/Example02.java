package org.example;

import org.example.util.Calculator;

public class Example02 {
    public static void main(String[] args) {
        int n=0;
        while(n <10){
            n= Calculator.add(n,1);
        }
        System.out.println("EXIT");
    }
}
