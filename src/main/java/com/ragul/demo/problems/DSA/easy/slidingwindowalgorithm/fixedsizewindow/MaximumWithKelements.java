//package com.ragul.demo.problems.DSA.easy.slidingwindowalgorithm.fixedsizewindow;
//
//import java.util.ArrayList;
//import java.util.List;
//
////Example:
////nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
////Window [1, 3, -1]: Maximum is 3
////Window [3, -1, -3]: Maximum is 3
////Window [-1, -3, 5]: Maximum is 5
////Window [-3, 5, 3]: Maximum is 5
////Window [5, 3, 6]: Maximum is 6
////Window [3, 6, 7]: Maximum is 7
//public class MaximumWithKelements {
//
//    public static void main(String[] args) {
//        int[] nums={1, 3, -1, -3, 5, 3, 6, 7};
//        int k=3;
//        List<Integer> sumList = new ArrayList<>();         List<Integer> maxList = new ArrayList<>();
//        System.out.println("Maximum in each sliding window 1 of size " + k + ": " + findMaxInSlidingWindow(nums, k, sumList, maxList));
//
//    }
//
//    private static List<Integer> findMaxInSlidingWindow(int[] nums, int k, List<Integer> sumList, List<Integer> maxList) {
////        int winSum = nums[0]+nums[1]+nums[2];
////        int max = winSum;
////        sumList.add(max);
////        maxList.add(max);
//
//        if (nums == null || nums.length < k || k <= 0) return 0;
//
////
//        int globalmax = 0;
//        int currentWindowMax=0;
//
//        //first window
//        for(int i=0;i<k;i++){
//            globalmax=Math.max(globalmax, nums[i]);
//        }
//        //globalmax =globalmax;
//
////        for (int i=1;i<=nums.length-k;i++){
////            int newElement = nums[i+k-1];
////
////            //just for practrise
//////            int oldElement = nums[i-1];
//////            winSum = winSum + newElement - oldElement; //starting from i=1 since nums[i-1] give ArraysOutOfBoundsException for i=0
//////            sumList.add(winSum);
////            max = Math.max(newElement,max);
////            maxList.add(max);
////        }
//
//        for (int i=k;i<nums.length;i++){
//            globalmax = ;
//
//            globalmax = Math.max(currentWindowMax, globalmax);
//            maxList.add(globalmax);
//        }
//        return maxList;
//    }
//}
////try with Deque
