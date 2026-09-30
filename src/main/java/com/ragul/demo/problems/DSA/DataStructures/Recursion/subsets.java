package com.ragul.demo.problems.DSA.DataStructures.Recursion;

import java.util.ArrayList;
import java.util.List;

public class subsets
{


        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(0, nums, new ArrayList<>(), result);
            return result;
        }

        private static void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
           if (index>=nums.length-1) {
               result.add(new ArrayList<>(current));
               return;
           }

            for (int i = index; i < nums.length; i++) {
                current.add(nums[i]);
                backtrack(i + 1, nums, current, result);
                current.remove(current.size() - 1);  // backtrack
                backtrack(i + 1, nums, current, result);
            }
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 3};
            List<List<Integer>> output = subsets(nums);

            System.out.println(output);
        }
    }

