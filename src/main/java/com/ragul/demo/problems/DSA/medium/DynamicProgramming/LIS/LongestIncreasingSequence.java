package com.ragul.demo.problems.DSA.medium.DynamicProgramming.LIS;


//LIS

//Input: arr[] = [3, 10, 2, 1, 20]
//Output: 3
//Explanation: The longest increasing subsequence is 3, 10, 20
//
//Input: arr[] = [30, 20, 10]
//Output:1
//Explanation: The longest increasing subsequences are [30], [20] and [10]
//
//
//Input: arr[] = [2, 2, 2]
//Output: 1
//Explanation:  We consider only strictly increasing.
//
//
//        Input: arr[] = [10, 20, 35, 80]
//Output: 4
//Explanation: The whole array is sorted

import java.util.Arrays;


public class LongestIncreasingSequence {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,2,3};
        int n = arr.length;
        System.out.println("Length of LIS using DP is " + lisUsingDP(arr, n));
        System.out.println("Length of LIS is " + lis(arr, n));
        System.out.println("Length of LIS is " + lis1(arr, n));
    }

    //nikhil video was clear than striver or any others
    //T O(n^2), Space O(n)
    private static int lisUsingDP(int[] arr, int n) {
        int[] dpLIS=new int[arr.length];
        Arrays.fill(dpLIS,1);

        for (int i=1;i<arr.length;i++){
            for (int j=0;j<i;j++){
                if (arr[i]>arr[j]){ //waste of time reclauclatin gofr same value
                    dpLIS[i]=Math.max(dpLIS[i], 1 + dpLIS[j]);
                }
            }
        }

        int maxLIS=1;
        for (int i=0;i<dpLIS.length;i++){
            System.out.print(" "+dpLIS[i]);
            maxLIS = Math.max(maxLIS,dpLIS[i]);
        }
        System.out.println();


        return maxLIS;
    }

    //O(n) time complexity, O(1) space complexity
    private static int lis(int[] arr, int n) {
        int count = 0;

        if (arr.length>0) count=1;
        for (int i=1; i<arr.length;i++){
            if (arr[i]>arr[i-1]){
                count++;
            }else{
                continue;
            }
        }
        return count;
    }

    //O(n^2) time complexity, O(n) space complexity
    private static String lis1(int[] arr, int n) {
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }
        return String.valueOf(max);
    }
}
