package com.ragul.demo.problems;
//
//             a
//            bca
//           bcabc
//          abcabca

//rough - total: 7
// 1 1
//2 3
//3 5
//4 7
public class two {
    public static void main(String args[]){
        int lines=4;
        String s="abc";
        char[] c=s.toCharArray();
        int noOfMaxCharInLine = 1;
        int maxChar = lines+lines-1;
        for(int i=1,j=0;i<=lines;i++,noOfMaxCharInLine=noOfMaxCharInLine+2){ //each line
            int count=1;
            int noOfSpaces = maxChar-noOfMaxCharInLine;
            int noOfPartialSpaces = noOfSpaces/2;
            int rowCount=1;
            while(rowCount<=noOfPartialSpaces){
                System.out.print(" ");
                rowCount++;
            }
            while (count<=noOfMaxCharInLine){

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
