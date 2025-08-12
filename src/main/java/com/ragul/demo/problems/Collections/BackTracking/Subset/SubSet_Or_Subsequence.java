package com.ragul.demo.problems.Collections.BackTracking.Subset;

//1 2 3
// 1 3 - subsequence
// 31 - not subsequence

//subset
//1
//1 2
//1 3

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//2
public class SubSet_Or_Subsequence {
    public static void main(String[] args) {
        int num[]={1,2,3};
        List<List<Integer>> allSubsets = new ArrayList<>();

        solveBT(0, new HashSet<>(),num,allSubsets);
        System.out.println(allSubsets);

    }

    private static void solveBT(int i, Set<Integer> bucket, int[] num, List<List<Integer>> allSubsets) {
        if(i>=num.length){
            allSubsets.add(new ArrayList<>(bucket)); // store a copy of current subset
            return;
        }
        bucket.add(num[i]);
        solveBT(i+1,bucket,num, allSubsets);
        bucket.remove(num[i]);
        solveBT(i+1,bucket,num, allSubsets);
    }
}
