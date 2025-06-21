package com.ragul.demo.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

//CombinationSum is a classic backtracking problem where we need to find all unique combinations of numbers from a given array that sum up to a target value.

//Note: 1. The same number may be chosen from array an unlimited number of times.
// 2. Unique combinations - Two combinations are unique if the frequency of at least one of the chosen numbers is different.

// For example, given candidates = [2, 3, 6, 7] and target = 7,
// the solution set is:
// [
//   [2, 2, 3],
//   [7]
// ]
// The order of the combinations does not matter, so [2, 2, 3] is considered the same as [3, 2, 2].


public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        //WAY 1
//        if (target < 0) { //if target is negative, no need to proceed further
//            return;
//        }
        for (int i = start; i < candidates.length; i++) {
            if(candidates[i]>target){ //WAY 2
                continue; //skip if candidate is greater than target
            }
            currentCombination.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1); //remove the last added element to backtrack
        }
    }
}
