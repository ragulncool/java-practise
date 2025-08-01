package com.ragul.demo.problems.DSA.easy.MaxContinousSubArraySum_KadaneAlgorithm;


//Slide Window Technique is not applicable here it contains negative numbers
//window technique is used when we have positive numbers only
//becaus if we have negative numbers, it will reduce the sum of the subarray and window cannot slide
public class MaxSubArraySum_Brutal_O_Npow2 {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    private static int maxSubArray(int[] arr) {
       int maxSum = Integer.MIN_VALUE;
         int currentSum;
         for(int i=0;i<arr.length;i++){
             currentSum = 0;
             for(int j=i;j<arr.length;j++) {
                    currentSum = currentSum + arr[j];
                    maxSum = Math.max(currentSum,maxSum);
// old way                    if (currentSum > maxSum) {
//                        maxSum = currentSum;
//                    }
             }
             }
        return maxSum;
    }

}
