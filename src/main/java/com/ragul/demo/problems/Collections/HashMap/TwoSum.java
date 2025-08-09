package com.ragul.demo.problems.Collections.HashMap;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[][] nums = {{2,7,11,15}};
        int[] target = {9};
        for(int i=0;i<nums.length;i++){
            System.out.println(checkTwoSum(nums[i], target[i]));
        }
    }

    private static List<Integer> checkTwoSum(int[] nums, int target) {
//        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap(); //sicne we need to return indice, storing it here

        for (int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return Arrays.asList(map.get(target-nums[i]), i);
            }
            map.put(nums[i],i);
        }
         return Arrays.asList(-1,-1);
    }
}
