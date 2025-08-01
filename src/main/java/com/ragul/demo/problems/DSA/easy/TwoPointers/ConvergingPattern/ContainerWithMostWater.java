package com.ragul.demo.problems.DSA.easy.TwoPointers.ConvergingPattern;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height)); // Output: 49
        System.out.println(maxAreaUsingBrutal(height)); // Output: 49

        int[] height1 = {1,1};
        System.out.println(maxArea(height1));
        System.out.println(maxAreaUsingBrutal(height1));

    }

    private static int maxAreaUsingBrutal(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int minHeight = Math.min(height[i], height[j]);
                int currentArea = width * minHeight;
                maxArea = Math.max(maxArea, currentArea);
            }
        }

        return maxArea;
    }

    private static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * minHeight);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
