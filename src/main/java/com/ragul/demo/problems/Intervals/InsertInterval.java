package com.ragul.demo.problems.Intervals;

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
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        // Add all intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newStart) {
            System.out.println("Adding interval before newInterval: " + intervals[i][0] + "," + intervals[i][1]);
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with newInterval.
        while (i < n && intervals[i][0] <= newEnd) { // here end of current > start of new and start of current <= end of new
            newInterval[0] = Math.min(newStart, intervals[i][0]);
            newInterval[1] = Math.max(newEnd, intervals[i][1]);
            System.out.println("Merging interval with newInterval: " + intervals[i][0] + "," + intervals[i][1]);
            i++;
        }
        result.add(newInterval); // Add the merged newInterval

        // Add all remaining intervals that start after newInterval ends
        while (i < n) {
            System.out.println("Adding interval after newInterval: " + intervals[i][0] + "," + intervals[i][1]);
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
