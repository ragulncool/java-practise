package com.ragul.demo.problems.Collections.HashMap;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
       int[] nums = {1,2,3,4};
       System.out.println(checkCOntains(nums));
    }

    private static boolean checkCOntains(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
