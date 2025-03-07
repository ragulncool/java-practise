package com.ragul.demo.problems;
//
//Example, consider the number:
//
//        Step 1: 163 => 1+6+3 = 10
//        Step 2: 10 => 1+0 = 1 => Hence 163 is a magic number
public class MagicNumber {

    public static void main(String[] args) {
        int num = 163;
        System.out.println(checkMagicNumber(num));

    }

    private static boolean checkMagicNumber(int num) {
        int sum=0;
        while (num>0 || sum>9){ //stop when num==0 and sum is single digit
            if(num==0){
                num = sum;
                sum=0;
            }
            sum = sum + num % 10;;
            num = num /10;

        }
        if(sum==1){
            return true;
        }else{
            return false;
        }
    }
}
