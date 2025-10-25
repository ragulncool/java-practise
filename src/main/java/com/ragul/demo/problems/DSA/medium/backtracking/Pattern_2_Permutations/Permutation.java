package com.ragul.demo.problems.DSA.medium.backtracking.Pattern_2_Permutations;


//no of permutation - 3!

import java.util.ArrayList;
import java.util.List;

//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//
//Example 1:
//
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//Example 2:
//
//Input: nums = [0,1]
//Output: [[0,1],[1,0]]
//
//Example 3:
//
//Input: nums = [1]
//Output: [[1]]
public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(formPermutations(nums));
    }

    private static List<List<Integer>> formPermutations(int[] nums) {
        List<List<Integer>> permList = new ArrayList<>();
        List<Integer> currentComb = new ArrayList<>();

        formPermutations(0,nums,permList,currentComb);
        return permList;
    }

    private static void formPermutations(int i, int[] nums, List<List<Integer>> permList, List<Integer> currentComb) {
        if(i==nums.length){
            permList.add(currentComb);
            return;
        }
        for(int j=0;j<nums.length;j++){
            currentComb.add(j);
            formPermutations(j,nums,permList,currentComb);
            currentComb.remove(currentComb.size()-1);
            formPermutations(j,nums,permList,currentComb);
        }
    }
}
