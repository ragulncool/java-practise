package com.ragul.demo.problems.DynamicProgramming;


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

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int n = arr.length;
        System.out.println("Length of LIS is " + lis(arr, n));
    }

    private static String lis(int[] arr, int n) {
        int[] finList = new int[n];
        for (int i = 0; i < n; i++) {
            finList[i] = 1;
        }

        finList[0]=arr[0];
        for (int i=1; i<arr.length-1;i++){
            if (arr[i]>arr[i-1]){
                finList[i]=arr[i];
            }else{
                continue;
            }
        }
        return String.valueOf(finList.length);
    }

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
