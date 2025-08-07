//package com.ragul.demo.problems.DSA.easy.TwoPointers.OppositeEnds_ConvergingPointers_ShrinkingWindow;
//
//public class MinimumSizeSubarraySum {
//    public static void main(String[] args) {
//        int[][] nums = {{2,3,1,2,4,3},{1,4,4},{1,1,1,1,1,1,1,1}};
//        int[] target = {7,1,11};
//        for (int i=0;i<nums.length;i++){
//            System.out.println(findMinimumSizeSubarraySum(nums[i],target[i]));
//        }
//    }
//
//    private static int findMinimumSizeSubarraySum(int[] nums, int target) {
//        int start=0, end=0, minLen=Integer.MAX_VALUE, currentWindowSum= 0;
//
//        while (start<nums.length && end<nums.length){
//            currentWindowSum = currentWindowSum + nums[end];
//            if (currentWindowSum < target){
//
//                end++;
//            }else{
//                currentWindowSum = currentWindowSum - nums[start];
//                if(currentWindowSum == target){
//                    minLen = Math.min(minLen, end-start+1);
//                }
//                start++;
//            }
//        }
//        return minLen;
//    }
//}
