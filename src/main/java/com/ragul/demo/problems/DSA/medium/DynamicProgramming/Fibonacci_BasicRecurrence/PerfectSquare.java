package com.ragul.demo.problems.DSA.medium.DynamicProgramming.Fibonacci_BasicRecurrence;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquare {
    public static void main(String[] args) {
        int num=13;
        System.out.println(findLeastNumberOfPerfectSqNosThatSumTo(num));
    }

    private static int findLeastNumberOfPerfectSqNosThatSumTo(int num) {
        List<Integer> perfSqNos = new ArrayList<>();

        //1 4 9
        int j=1;
        while (j*j<=num){
            perfSqNos.add(j*j);
            j++;
        }

        int[] dpMinPerfSq = new int[num+1];
        dpMinPerfSq[0]=0;
        for (int currentNo=1;currentNo<dpMinPerfSq.length;currentNo++){

            dpMinPerfSq[currentNo]=Integer.MAX_VALUE;
            for (int perfSq:perfSqNos){
                if(currentNo>=perfSq && dpMinPerfSq[currentNo-perfSq]!=Integer.MAX_VALUE){
                    dpMinPerfSq[currentNo] = Math.min(dpMinPerfSq[currentNo], 1+ dpMinPerfSq[currentNo-perfSq]);
                }
            }
            System.out.println("DP of "+currentNo+" is : "+dpMinPerfSq[currentNo]);

        }

        return dpMinPerfSq[num]==Integer.MAX_VALUE?-1:dpMinPerfSq[num];
    }
}
