package com.ragul.demo.problems.DynamicProgramming.waysForClimbingStairs;

//The person can climb either 1 stair or 2 stairs at a time

//Input: n = 1
//        Output: 1
//        Explanation: There is only one way to climb 1 stair.
//
//
//        Input: n = 2
//        Output: 2
//        Explanation: There are two ways to reach 2th stair: {1, 1} and {2}.
//
//
//        Input: n = 4
//        Output: 5
//        Explanation: There are five ways to reach 4th stair: {1, 1, 1, 1}, {1, 1, 2}, {2, 1, 1}, {1, 2, 1} and {2, 2}.
//Time Complexity: O(2n), as we are making two recursive calls for each stair.
//Auxiliary Space: O(n), as we are using recursive stack space.

public class withoutDP {

    public static void main(String[] args) {
        //intialization
        int[] ways = {1,2}; //can extend to generic program using for loop
        int stairs = 3;

        int maxSize = stairs+1;
        System.out.println(waysOfClimbing(stairs));
    }

    private static int waysOfClimbing(int stairs) {

        if(stairs==0 || stairs==1)  return 1; //edge case

      //  if(result[stairs]!=-1) return result[stairs]; //return if result valid

        return waysOfClimbing( stairs-1)+waysOfClimbing(stairs-2);
    }

}
