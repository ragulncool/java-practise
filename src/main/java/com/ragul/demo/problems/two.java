package com.ragul.demo.problems;

public class two {


    public static void main(String args[]){
        int lines=4;
        String s="abc";
        char[] c=s.toCharArray();
        int noOfMaxChar = 1;
        int maxChar = lines+lines-1;
        for(int i=1,j=0;i<=lines;i++,noOfMaxChar=noOfMaxChar+2){ //each line
            int count=1;
            int noOfSpaces = maxChar-noOfMaxChar;
            int noOfPartialSpaces = noOfSpaces/2;
            int rowCount=1;
            while(rowCount<=noOfPartialSpaces){
                System.out.print(" ");
                rowCount++;
            }
            while (count<=noOfMaxChar){

                //System.out.print("*");
                System.out.print(c[j]);

                if(j==s.length()-1){
                    j=0;
                }else{
                    j++;
                }
                count++;
            }
            System.out.println("");
        }

    }




}
