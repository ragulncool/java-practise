package com.ragul.demo;


import java.util.Collections;

public class Snippets {
    public static void main(String[] args) {
        String s="true falsdse sdf";
        boolean b= Boolean.parseBoolean(s);
        System.out.println(b); //will check "true" equals s else will print false for any string

        int[] a=new int[10];
        System.out.println(a); //10
    }
}
