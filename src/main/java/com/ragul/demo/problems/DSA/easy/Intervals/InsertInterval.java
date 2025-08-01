package com.ragul.demo.problems.DSA.easy.Intervals;

import java.util.ArrayList;
import java.util.List;


public class InsertInterval {
    public static void main(String[] args) {
        InsertInterval sol = new InsertInterval();

        System.out.print("Example 1: ");
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] mergedIntervals1 = sol.insert(intervals1, newInterval1);
        for (int[] interval : mergedIntervals1) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println(); // Expected: [1,5] [6,9]

        System.out.print("Example 2: ");
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] mergedIntervals2 = sol.insert(intervals2, newInterval2);
        for (int[] interval : mergedIntervals2) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println(); // Expected: [1,2] [3,10] [12,16]

        System.out.print("Example 3: ");
        int[][] intervals3 = {{1, 5}};
        int[] newInterval3 = {2, 3};
        int[][] mergedIntervals3 = sol.insert(intervals3, newInterval3);
        for (int[] interval : mergedIntervals3) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println(); // Expected: [1,5]
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int left = 0;
        int n = intervals.length;

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        int currStart = intervals[left][0];
        int currEnd = intervals[left][1];

        // Add all intervals that end before newInterval starts
        while (left < n && currEnd < newStart) {
            System.out.println("Adding interval before newInterval: " + currStart + "," + currEnd);
            result.add(intervals[left]);
            left++;
        }

        // Merge overlapping intervals with newInterval.
        while (left < n && currStart <= newEnd) { // here end of current > left of new and left of current <= end of new
            newInterval[0] = Math.min(newStart, currStart);
            newInterval[1] = Math.max(newEnd, currEnd);
            System.out.println("Merging interval with newInterval: " + currStart + "," + currEnd);
            left++;
        }
        result.add(newInterval); // Add the merged newInterval

        // Add all remaining intervals that left after newInterval ends
        while (left < n) {
            System.out.println("Adding interval after newInterval: " + currStart + "," + currEnd);
            result.add(intervals[left]);
            left++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
