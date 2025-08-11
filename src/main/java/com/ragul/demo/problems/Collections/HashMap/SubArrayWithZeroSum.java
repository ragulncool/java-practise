package com.ragul.demo.problems.Collections.HashMap;

import java.util.*;

public class SubArrayWithZeroSum {
    /// return true
    /// return one or all subarray with sum 0
    /// count of subarray with sum 0
    public static void main(String[] args) {
        //O(n2) subarray

        //O(n) using Hashmap
        int [][] nums={{4,2,-3,1,6}};
        for (int i=0;i<nums.length;i++){
            System.out.println(find(nums[i]));
           System.out.println(findElements(nums[i],0));
        }
    }

    private static int[] findElements(int[] nums, int k) {
        int currentSum=0;
        Map<Integer,Integer> prefixSumMap=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            currentSum=currentSum+nums[i];

            if (prefixSumMap.containsKey(currentSum-k)) {
                int start = prefixSumMap.get(currentSum-k) + 1;
                int end = i;
                System.out.println("start end :"+start+" "+end);
                // Extract the subarray
                return Arrays.copyOfRange(nums, start, end + 1);
            } else {
                prefixSumMap.put(currentSum, i);
            }
        }
        return null;
    }

    private static boolean find(int[] nums) {
        int sum=0;
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            sum=sum+nums[i];

            if(set.contains(sum)){
                System.out.println("Set contains sum: "+sum);
                return true;
            }
            set.add(sum);
            System.out.println("Set: "+set);
        }
        return false;

        //start=map.get(sum)+1
        //end-currentIndex
    }
}
