package com.ragul.demo.snippets;


public class ArraySnippet{
    public static void main(String[] args) {
        String s="true falsdse sdf";
        boolean b= Boolean.parseBoolean(s);
        System.out.println(b); //will check "true" equals s else will print false for any string

        int[] a=new int[10];
        System.out.println(a); //10

        System.out.println((char) 65);
        int[] ascii={65,66,67,68,69};
        String s1=new String(ascii,1,3);
        System.out.println(s1);
    }
}
