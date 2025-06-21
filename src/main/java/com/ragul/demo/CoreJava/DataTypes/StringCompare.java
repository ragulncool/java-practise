package com.ragul.demo.CoreJava.DataTypes;

public class StringCompare {
    public static void main(String args[]) {

        System.out.println("===STRING LITERAL===");
        String s1="hello";
        String s2="hello";
        String s3="world";

        System.out.println(s1.equals(s2)); //boolean
        System.out.println(s1.compareTo(s2)); //returns 0 if equals else different

        System.out.println(s1==s2); //comapres memory location - true because points to same value in SCP
        System.out.println(s1.equals(s3));
        System.out.println(s1.compareTo(s3));

        System.out.println("===STRING USING NEW KEYWORD===");
        String s4=new String("hello");
        String s5=new String("hello");
        System.out.println(s4==s5); //false because different object in PriorityQueueOrHeap area
        System.out.println(s4.equals(s5));
        System.out.println(s4.compareTo(s5));

    }
    }
