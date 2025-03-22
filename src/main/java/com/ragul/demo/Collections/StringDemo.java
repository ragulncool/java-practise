package com.ragul.demo.Collections;

public class StringDemo {
    //hashcode doesnt need to be mention address. object sotred in diff locations can have same hashcode

    public static void main(String[] args) {
        String s ="hello1";
        String s1 ="hello1";
        System.out.println(s.hashCode()+" "+s1.hashCode());
        System.out.println(s==s1); //reused from string pool

        String s2 = new String("hello1");
        String s3 = new String("hello1");
        System.out.println(s2.hashCode()+" "+s3.hashCode());
        System.out.println((s2==s)+" "+(s2==s1)+" "+(s2==s3)); //new object created

        s1="world"; //new object created
        System.out.println(s.hashCode()+" "+s1.hashCode());
        System.out.println(s==s1);

        //IMMUTABLE
        String s5 = "Hello";
        s5.concat("World");
        System.out.println(s5); //Hello - value of s5 is not changed

    }
}
