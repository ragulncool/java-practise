package com.ragul.demo.problems;

//Write a snippet to print the char in below format
//        Eg: javascriptAA
//        J
//        Av
//        Asc
//        Ript

public class One {

    public static void main(String args[]){
        String s= "javascript";


        int start=0, end=0;
        int count=1;
        for(int i=0;i<s.length();i++){
            if(end>s.length()-1){
                end=s.length()-1;
                String res1 = s.substring(start,end+1); //subList(startIndex, EndIndex+1).
                System.out.println(res1);
                break;
            }
            String res = s.substring(start,end+1);
            System.out.println(res);
            start=end+1;
            end=start+count;
            count++;
        }
    }
}
