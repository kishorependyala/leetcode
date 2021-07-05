package com.kp;

import java.util.Arrays;

public class Sample {
    static int count = 0;
    public static void main(String[] args){
       try{
           System.out.println("Hello World|".substring(6,12));
           badMethod();
           System.out.println("B");
       }catch(Exception e){
           System.out.println("c");
       }finally{
           System.out.println("D");
       }
    }

    private static void badMethod() {
        throw new Error();

    }
}
