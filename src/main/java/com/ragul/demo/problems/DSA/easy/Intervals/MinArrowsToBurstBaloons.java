package com.ragul.demo.problems.DSA.easy.Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowsToBurstBaloons {
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println("Minimum number of arrows to burst all balloons: " + findMinArrowShots(points));
    }

    private static String findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return "0";
        }

        // Sort the balloons by their end points
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        System.out.println(Arrays.deepToString(points));

        int arrows = 1; // At least one arrow is needed
        int end = points[0][1]; // End of the first balloon

        for (int i = 1; i < points.length; i++) {
            // If the start of the current balloon is greater than the end of the last balloon,
            // we need a new arrow
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1]; // Update the end to the current balloon's end
            }
            //else ignore the current balloon as it can be burst with the same arrow
            // means it is in same interval. no need to increment arrows
        }

        return String.valueOf(arrows);
    }
}

//        In essence, sorting by end points ensures that the greedy choice made at each step (shooting an arrow at the earliest possible end point) leads to a globally optimal solution by maximizing the number of balloons burst with each arrow. Sorting by start points does not provide this crucial property for optimal arrow placement.