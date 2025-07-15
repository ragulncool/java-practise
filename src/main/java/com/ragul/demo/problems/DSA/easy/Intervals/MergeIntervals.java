package com.ragul.demo.problems.DSA.easy.Intervals;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main(String args[]) {
        //if unsorted, sort using start value
        int[][] arr ={ {1, 2}, {2, 4}, {5, 7},{6, 9}, {7, 27}, {26, 31},{33,35}}; //{{7, 8}, {1, 5}, {2, 4}, {4, 6}};
        int[][] arr2 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] arr3 = {{1,4},{4,5}};
        //MEANING EG: 7,10 = MEANS 7 TO 10 = 7,8,9,10

        List<int[]> res = mergeOverlap(arr);
        List<int[]> res1 = mergeOverlap(arr2);
        List<int[]> res2 = mergeOverlap(arr3);

        System.out.println("Merged Intervals:");
        for (int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        System.out.println("Merged Intervals:");
        for (int[] interval : res1) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        System.out.println("Merged Intervals:");
        for (int[] interval : res2) {
            System.out.println(interval[0] + " " + interval[1]);
        }

    }

    private static List<int[]> mergeOverlap(int[][] arr) {
        List<int[]> res = new ArrayList<>();
        int start = arr[0][0];
        int end = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            if (end >= arr[i][0]) { //if end of current interval >= start of next interval
                end = Math.max(end, arr[i][1]); //merge intervals by updating end
            } else {
                res.add(new int[]{start, end}); //add merged interval to result
                start = arr[i][0]; //update start for next interval
                end = arr[i][1]; //update end for next interval
            }
        }
        res.add(new int[]{start, end}); //add the last merged interval

        return res;
    }

//    private static List<int[]> mergeOverlap(int[][] arr) {
//        List<int[]> res = new ArrayList<>();
//        int start,end;
//        for(int i=0;i<arr.length;i++){
//             start = arr[i][0];
//             end = arr[i][1];
//
//            while(i+1< arr.length && end >= arr[i+1][0]){ //if end of current interval >= start of next interval
//                i++;
//            }
//            end = arr[i][1];
//
//            while(i+1< arr.length && end >= arr[i+1][0]){ //end of current >=start of next interval AND end of current <= end of next
//                end = arr[i+1][1];
//                i++;
//            }
//
//            int[] subArr = {start,end};
//            res.add(subArr);
//        }
//        return res;
//    }
}