package com.ragul.demo.problems.Collections.Arrays;

public class MaximumSubarray {
    //number of subarrays = n(n+1)/2
    //eg: for n=5, subarrays = 5(5+1)/2 = 15
    //subarrays = [5],[5,4],[5,4,1],[5,4,1,7],[5,4,1,7,8],
    // for 4: [4],[4,1],[4,1,7],[4,1,7,8]
    public static void main(String[] args) {
        int[] nums = new int[]{-4,5,-1,7,8};
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<nums.length;i++){
            int subArraySum=0;
            for (int j=i; j<nums.length;j++){
                subArraySum = subArraySum + nums[j];
            }
            maxSum = Math.max(maxSum,subArraySum);
        }
      System.out.println("Maximum subarray sum is: " + maxSum);
    }
}
