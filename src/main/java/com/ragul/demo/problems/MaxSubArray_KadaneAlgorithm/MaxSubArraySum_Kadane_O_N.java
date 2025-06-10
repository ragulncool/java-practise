package com.ragul.demo.problems.MaxSubArray_KadaneAlgorithm;

public class MaxSubArraySum_Kadane_O_N {
    public static void main(String[] args) {
        //int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
       // int[] arr = {2, 3, -8, 7, -1, 2, 3};
       // int[] arr = {-2,-4};
     //   int[] arr = {5, 4, 1, 7, 8};
        int[] arr = {1, 2, -1, 4, 5};
        System.out.println(maxSubArray(arr));
    }

    private static int maxSubArray(int[] arr) {
       int maxSum = Integer.MIN_VALUE;
       int currentSum = 0,tempSum = 0;

         for(int i=0;i<arr.length;i++){
             tempSum = currentSum + arr[i];
             if (tempSum < arr[i]){
                 currentSum = arr[i]; //reset currentSum to current elemt - ignore all previous elements since current value is enough for max
             }else{
                 currentSum = tempSum;
             }
             maxSum = Math.max(currentSum, maxSum);
         }
        return maxSum;
    }
}
