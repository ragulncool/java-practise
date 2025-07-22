package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.variablesizewindow;

public class CountOfSubArraysWithGivenSum {
    public static void main(String args[]) {
        String s="111";
        int[] arr = new int[s.length()];
        for (int i=0;i<s.length();i++) {
            arr[i] = s.charAt(i)-'0'; //converting char to int
        }
        int givenSum=2;
        System.out.println("Subarrays with sum " + givenSum + " are: "+slidingWindowApproach(arr,givenSum));

        int[] arr2 = new int[]{1,2,3};
        int givenSum2=3;
        System.out.println("Subarrays with sum " + givenSum + " are: "+slidingWindowApproach(arr2,givenSum2));
    }




    private static int slidingWindowApproach(int[] arr, int givenSum) {
        int count=0;
        int start=0, end =0;
        int sum=0;

        if(arr[0]>givenSum){
            return 0; //if first element is greater than given sum, no subarray can be formed
        }

        while (end<arr.length) {
            sum += arr[end];

            // If current sum exceeds the given sum, move the start pointer (shift window)
            while (sum > givenSum && start <= end) {  //working without start>=end condition, but it is better to have it
                sum = sum - arr[start];
                start++;
            }

            if (sum == givenSum) { //for <= , remove this condition
                count++;
                System.out.println("Subarray found from index " + start + " to " + end);

                //if elements are only +ve numbers, we can break here
//                sum = sum - arr[start];
//                start++;
            }

            end++;
        }
        return count;
    }

    }


