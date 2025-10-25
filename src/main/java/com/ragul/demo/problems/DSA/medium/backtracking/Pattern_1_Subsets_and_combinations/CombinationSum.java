package com.ragul.demo.problems.DSA.medium.backtracking.Pattern_1_Subsets_and_combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * CombinationSum is a classic backtracking problem where we need to find all unique
 * combinations of numbers from a given array that sum up to a target value.
 *
 * Rules:
 * 1. A number may be chosen multiple times.
 * 2. Two combinations are unique if they differ in the count of at least one number.
 *
 * Example:
 * Input:  candidates = [2, 3, 6, 7], target = 7
 * Output: [[2, 2, 3], [7]]
 *
 * Note: [2, 2, 3] is considered the same as [3, 2, 2].
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start,
                                  List<Integer> currentCombination,
                                  List<List<Integer>> result) {
        if (target == 0) {
            // Found a valid combination
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        if (target < 0) { //way 1
            // Exceeded the sum, stop exploring this path
            return;
        }

        for (int i = start; i < candidates.length; i++) {


//            if(candidates[i]>target){ //WAY 2
//                continue; //skip if candidate is greater than target
//            }

            // Choose the current candidate
            currentCombination.add(candidates[i]);

            // Explore further with the same candidate (since it can be reused)
            backtrack(candidates, target - candidates[i], i, currentCombination, result);

            // Undo the choice (backtrack) to try the next candidate
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}

