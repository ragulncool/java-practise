package com.ragul.demo.CoreJava.DataTypes;

public class StringDemo {
public static void main(String args[]){
    String var1="hello";
    String var2=new String("Welcome to the world");

    System.out.println("Length: " + var1.length());
    System.out.println(var2.substring(1,2)); //start index, end index-1
    char[] charVAr = var2.toCharArray();
    System.out.println(charVAr);

    //less used
    System.out.println(var1.toUpperCase());
    System.out.println(var1.toLowerCase());
    System.out.println(var1.indexOf("e"));
    System.out.println(var1.indexOf("aa")); //OUTPUT: -1 SINCE NOT THERE
    System.out.println(var2.indexOf("to"));
    System.out.println(var1+" "+var2);
    System.out.println(var1.concat(var2));
   // Eg: replace null by empty
    System.out.println(var2.replaceAll(" ", "")); //s1 is string
    System.out.println(var2.replace("world", "nature")); //s1 is string
}
}
