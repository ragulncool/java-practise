package com.ragul.demo.problems;

public class SwapWithoutUsingThirdVar {

    public static void main(String[] args) {
        int a=11, b=36;

        a=a+b; //11+36
        b=a-b; //11+36  -36
        a=a-b; //11+36  -11
        System.out.println("a:"+a+"    b:"+b);
    }
}
