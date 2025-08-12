package com.ragul.demo.problems.Collections.Recursion.Fibonacci;

//0 1 1 2 3 5 8
//T 2^n
//S n
public class Fibonacci {
    public static void main(String[] args) {
        //print diagram how n-1 and n2 called
        System.out.println(fib(5));
        //T  2 pow n
    }

    private static int fib(int num) {
        if (num<=1) return num; //for 0 it is 0 and for 1 it is 1

        //left side will be executed first, see image
        return fib(num-1)+ fib(num-2);
    }


}
