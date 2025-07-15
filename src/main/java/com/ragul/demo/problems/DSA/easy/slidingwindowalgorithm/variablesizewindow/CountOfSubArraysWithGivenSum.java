package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.variablesizewindow;

public class CountOfSubArraysWithGivenSum {
    public static void main(String args[]) {
        String s="1245634";
        int[] arr = new int[s.length()];
        for (int i=0;i<s.length();i++) {
            arr[i] = s.charAt(i)-'0'; //converting char to int
        }
        int givenSum=6;
        System.out.println("Subarrays with sum " + givenSum + " are: "+slidingWindowApproach(arr,givenSum));
     //   System.out.println(brutalApproach(arr, giveSum));
    }

//NO TIME
//    private static int brutalApproach(String s) {
//        int maxlength = 0;
//
//        for (int i=0;i<s.length();i++) {
//            boolean[] visited = new boolean[256];
//           // int windowlen = 0; commented code are my logic
//
//            for (int j = i; j < s.length(); j++) {
//                char c = s.charAt(j);
//
//                if (visited[c]) {
//                   // maxlength=Math.max(windowlen,maxlength);
//                    break;
//                } else {
//                   // windowlen++;
//                    maxlength = Math.max(j-i+1, maxlength); //NOTE: for single char, it will be 1
//                    visited[c] = true;
//                }
//            }
//        }
//        return maxlength;
//    }

    private static int slidingWindowApproach(int[] arr, int givenSum) {
        int count=0;
        int start=0, end =0;
        int sum=0;

        if(arr[0]>givenSum){
            return 0; //if first element is greater than given sum, no subarray can be formed
        }

        while (end<arr.length){

           if(sum==givenSum){
              count++;
              System.out.println("Index "+start + " " + (end-1));
           }

            sum=sum+arr[end];


            while (sum>givenSum) {
                  sum=sum-arr[start];
                  start++;
               }
            end++;

        }
        return count;

    }
    }


