package com.ragul.demo.problems.Intervals;

import java.util.ArrayList;
import java.util.List;

public class MergeOverlap {
    public static void main(String args[]) {
        //if unsorted, sort using start value
        int[][] arr ={ {1, 2}, {2, 5}, {4, 6},{7, 8}, {10, 27}, {26, 31}}; //{{7, 8}, {1, 5}, {2, 4}, {4, 6}};


        List<int[]> res = mergeOverlap(arr);

        for (int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    private static List<int[]> mergeOverlap(int[][] arr) {
        List<int[]> res = new ArrayList<>();
        int start,end;
        for(int i=0;i<arr.length;i++){
             start = arr[i][0];
             end = arr[i][1];

            while(i+1< arr.length && end >= arr[i+1][0]){
                i++;
            }
            end = arr[i][1];

            int[] subArr = {start,end};
            res.add(subArr);

        }
        return res;

    }
}