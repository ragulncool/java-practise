package com.ragul.demo.problems.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//        Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//        Total amount you can rob = 1 + 3 = 4.
//        Example 2:
//
//        Input: nums = [2,7,9,3,1]
//        Output: 12
//        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//        Total amount you can rob = 2 + 9 + 1 = 12.
public class HouseRobber {


    //below is the non dp solution
    public static void main(String[] args) {
        Integer nums[] = {2,7,9,3,1};
        System.out.println(findByDPApproach(nums));
        System.out.println(findByBrutalApproach(nums));
    }

    private static int findByDPApproach(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill the DP array
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[n-1];
    }

    private static int findByBrutalApproach(Integer[] nums) {

        int leftSum=0;
        for (int i=0;i<nums.length;i=i+2){
            leftSum = leftSum+nums[i];
        }

        int rightSum=0;
        for (int i=1;i<nums.length;i=i+2){
            rightSum = rightSum+nums[i];
        }

        return Math.max(leftSum,rightSum);
    }
}



