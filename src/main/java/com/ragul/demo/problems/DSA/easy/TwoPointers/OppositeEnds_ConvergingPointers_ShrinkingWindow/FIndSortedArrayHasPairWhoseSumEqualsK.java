package com.ragul.demo.problems.DSA.easy.TwoPointers.OppositeEnds_ConvergingPointers_ShrinkingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FIndSortedArrayHasPairWhoseSumEqualsK {
    public static void main(String[] args) {
        int[][] nums= {{1,3,5,7,9},{1}};
        int[] target = {12,1};
        for(int i=0;i<nums.length;i++){
            System.out.println(findSortedArrayHasPairWhoseSumEqualsK(nums[i],target[i]));
        }
    }

    private static List<Integer> findSortedArrayHasPairWhoseSumEqualsK(int[] nums, int target) {
        int start=0, end = nums.length - 1;

        //edge case
        if (nums == null || nums.length < 2) {
            return Arrays.asList(-1, -1); // No valid pair
        }

        while (start<end){
            int sum = nums[start] + nums[end];

            if(sum==target){
                return new ArrayList<>(Arrays.asList(nums[start],nums[end]));
            }else if(sum<target){
                start++; //increase sum
            }else{
                end--;
            }
        }
        return new ArrayList<>(Arrays.asList(-1,-1));
    }
}
