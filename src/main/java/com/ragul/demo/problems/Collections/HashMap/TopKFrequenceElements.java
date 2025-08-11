//package com.ragul.demo.problems.Collections.HashMap;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class TopKFrequenceElements {
//
//        //use map to count frequency
//        //sort based on value
//        //return top k elements
//        public static void main(String[] args) {
//            int[][] nums={{1,1,1,2,2,3},{1}};
//            int[] k={2,1};
//            for(int i= 0;i<nums.length;i++){
//                System.out.println(findtop(nums[i],k[i]));
//            }
//        }
//
//    private static boolean findtop(int[] nums, int k) {
//            Map<Integer,Integer> map = new HashMap<>();
//
//            for (int i=0;i<nums.length;i++){
//                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//
////                if(map.size()>k){
////
////                }
//            }
//
//            for(Map.Entry nmtry : map.entrySet()){
//
//            }
//
//
//    }
//}
