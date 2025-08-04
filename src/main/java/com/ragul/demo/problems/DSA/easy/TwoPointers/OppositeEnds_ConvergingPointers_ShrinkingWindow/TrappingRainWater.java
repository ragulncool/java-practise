package com.ragul.demo.problems.DSA.easy.TwoPointers.OppositeEnds_ConvergingPointers_ShrinkingWindow;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height)); // Output: 6

        int[] height1 = {4,2,0,3,2,5};
        System.out.println(trap(height1)); // Output: 9
    }

    private static boolean trap(int[] height) {
        int n = height.length;
        if (n < 3) return false; // At least 3 bars are needed to trap water

        int left = 0, right = n - 1;
        int leftMax = height[left], rightMax = height[right];
        int waterTrapped = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped = waterTrapped + leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped = waterTrapped + rightMax - height[right];
            }
        }

        System.out.println("Water trapped: " + waterTrapped);
        return true;
    }
}
