package com.ragul.demo.CoreJava.DataTypes;

public class NumbersAndStringsDemo {
    public static void main(String args[]){
        int x = 10;
        int y = 20;
        int z = x + y;
        System.out.println(z);

        String x1 = "10";
        String y1= "20";
        String z1 = x1 + y1;  // z will be 1020 (a String)
        System.out.println(z1);

        String x2= "10";
        int y2 = 20;
        String z2 = x2+ y2; //If you add a number and a string, the result will be a string concatenation:
        System.out.println(z2);

        int x3= 10;
        int y3 = 20;
        String z3 = "20"+x3+y3; //If you add a string and any numbers, the result will be a string concatenation:
        System.out.println(z3);
        System.out.println(x3+y3+"20"); //string at last. hence do addition and then do concatenaion


    }
}
