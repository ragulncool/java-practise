package com.ragul.demo.problems.DSA.medium.DynamicProgramming.waysForClimbingStairs;

import java.util.Arrays;

//MemoizationDP - adding a variable to store results to avoid reexecution

//Time Complexity: O(n), as we compute each subproblem only once using memoization. (redcues from 2 pow n without DP)
        //Auxiliary Space: O(n), due to the memoization array and the recursive stack space(both take linear space only).
public class MemoizationDP {

    public static void main(String[] args) {
        //initialization
        int[] ways = {1,2}; //can extend to generic program using for loop
        int stairs = 3;

        int maxSize = stairs+1;
        int[] result = new int[maxSize];
        Arrays.fill(result,-1);
        System.out.println(waysOfClimbing(result, stairs));
    }

    private static int waysOfClimbing(int[] result, int stairs) {

        if(stairs==0 || stairs==1)  return 1; //edge case

        //*****BELOW LINE IS MEMOIZATION - REUSING RESULTS ELSE CALCULATE AND STORE FOR FUTURE*****
        if(result[stairs]!=-1) return result[stairs]; //return if result valid for MemDP to reduce re execution

        int currentResult = waysOfClimbing(result, stairs - 1) + waysOfClimbing(result, stairs - 2);
        result[stairs]=currentResult;

        return currentResult;
//        int sum=0;
//        for(int i=0;i<ways.length;i++){
//            sum = sum +waysOfClimbing(result, stairs-i);
//            return sum;
//        }
    }

}
