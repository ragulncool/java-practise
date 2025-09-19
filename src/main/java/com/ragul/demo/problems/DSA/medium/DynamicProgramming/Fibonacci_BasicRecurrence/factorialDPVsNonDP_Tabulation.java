package com.ragul.demo.problems.DSA.medium.DynamicProgramming.Fibonacci_BasicRecurrence;

import java.util.Arrays;

//Memoization is not useful
public class factorialDPVsNonDP_Tabulation {

    public static void main(String[] args) {
        int num=10;

        long start = System.nanoTime();
        int maxSize = num+1;
        int[] factRes = new int[maxSize];
        Arrays.fill(factRes,-1); //impossible values

        System.out.println(factDP(num,factRes));
        long end = System.nanoTime();
        System.out.println("Using DP "+ (end-start));

        long start1 = System.nanoTime();
        System.out.println(factNonDP(num));
        long end1 = System.nanoTime();
        System.out.println("Without Using DP "+ (end1-start1));
    }

    private static int factDP(int num, int[] factRes) {
//        if (num==0 || num==1) return 1;
//        if(factRes[num]!=-1) return factRes[num];
//        factRes[num] = num * factDP(num-1, factRes);
//        return factRes[num];
        factRes[0] =1; factRes[1] =1;

        for(int i=2;i<=num;i++){
            factRes[i]= i* factRes[i-1];
        }
        return factRes[num];
    }

    private static int factNonDP(int num) {
        if (num==0 || num==1) return 1;
        return num * factNonDP(num-1);
    }
}
