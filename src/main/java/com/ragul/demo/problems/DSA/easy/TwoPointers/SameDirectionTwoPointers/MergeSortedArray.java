package com.ragul.demo.problems.DSA.easy.TwoPointers.SameDirectionTwoPointers;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[][] nums1 = {{1, 2, 3, 0, 0, 0},{1},{0}};
        int[][] nums2 = {{2, 5, 6},{},{1}};

        for(int i=0;i<nums1.length;i++){
            System.out.println(findMergedSortedArray(nums1[i], nums2[i]));

        }
    }

    //Time complexity - nums1.length + nums2.length , Space - nums1.length + nums2.length
    private static List<Integer> findMergedSortedArray(int[] nums1, int[] nums2) {
        // int[] nums3 = new int[nums1.length + nums2.length];
        //if we use arary to return, remaining elements like 0 where we going to skip will be present
        List<Integer> nums3 = new ArrayList<>();
        int first = 0, second = 0;

        while (first < nums1.length && second < nums2.length) {
            //skip zero elements
            if (nums1[first] == 0) {
                first++;
                continue;
            } else if (nums2[second] == 0) {
                second++;
                continue;
            }

            if (nums1[first] < nums2[second]) {
                nums3.add(nums1[first]);
                first++;
            } else {
                nums3.add(nums2[second]);
                second++;
            }

        }
        //copy remaining elements  SURE ONLY ONE OF THE BELOW FOR LOOPS WILL EXECUTE
        while (first < nums1.length) {
            nums3.add(nums1[first]);
            first++;
        }
        while (second < nums2.length) {
            nums3.add(nums2[second]);
            second++;
        }
        return nums3;

    }
}