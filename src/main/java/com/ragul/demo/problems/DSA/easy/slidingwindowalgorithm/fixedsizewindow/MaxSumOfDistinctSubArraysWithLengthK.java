//package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.fixedsizewindow;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//
////DOESNOT WORKING FOR ANY CASES
//public class MaxSumOfDistinctSubArraysWithLengthK {
//    public static void main(String[] args) {
//        int[][] nums= {{1,5,4,2,9,9,9},{4,4,4},{4,4,4,5,6,7,7,8,8}};
//        int[] k={3,3,3};
//        for (int i=0; i<nums.length; i++){
//            System.out.println("Maximum number of vowels is: " + findMax(nums[i], k[i]));
//        }
//    }
//
//    private static int findMax(int[] num, int k) {
//        int currentWindowSum=0;
//        Set<Integer> windowElements = new HashSet<>();
//
//        //initial window
//        for (int i=0; i<k; i++){
//            if(windowElements.contains(num[i])) {
//                currentWindowSum = 0;
//                break; //if we use contunie then 4 will be added
//            }else
//            {
//                windowElements.add(num[i]);
//                currentWindowSum = currentWindowSum + num[i];
//            }
//        }
//
//        //sliding window
//        for (int i=k; i<num.length; i++){
//            windowElements.remove(num[i-k]);
//
//            if(windowElements.contains(num[i])) continue;
//            else windowElements.add(num[i]);
//
//            currentWindowSum=currentWindowSum+num[i]-num[i-k];
//            System.out.println(currentWindowSum);
//        }
//
//
//        return currentWindowSum;
//    }
//}
