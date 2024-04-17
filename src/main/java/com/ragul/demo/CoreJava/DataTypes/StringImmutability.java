package com.ragul.demo.CoreJava.DataTypes;

public class StringImmutability {
    public static void main(String args[]){
        String s="hello";
        s.concat("world");
        System.out.println(s);     //immutability

        s=s.concat("world");
        System.out.println(s);    //this will work

        StringBuffer s1=new StringBuffer(s);
        s1.append("one");
        System.out.println(s1);   //mutability
    }
}
