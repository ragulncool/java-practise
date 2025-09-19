package com.ragul.demo.problems.DSA.medium.DynamicProgramming.Fibonacci_BasicRecurrence;

import java.util.Arrays;

//0 1 1 2 3 5 8
//T 2^n
//S n


public class Fibonacci_Memoization {
    public static void main(String[] args) {
        int num=40;
        int[] dp = new int[num+1];
        Arrays.fill(dp,-1);

        long start = System.nanoTime();
        System.out.println(fibWithDP(num,dp));
        long stop = System.nanoTime();
        System.out.println(stop-start);

        start = System.nanoTime();
        System.out.println(fibWithoutDP(num));
        stop = System.nanoTime();
        System.out.println(stop-start);
    }

    private static int fibWithDP(int num, int[] dp) {
        if (num<=1) return num;

        if(dp[num]!=-1) return dp[num];

        int result =  fibWithDP(num-1,dp)+ fibWithDP(num-2,dp);
        dp[num] = result;
        return result;
    }

    private static int fibWithoutDP(int num) {
        if (num<=1) return num;

        return fibWithoutDP(num-1)+ fibWithoutDP(num-2);
    }
}
