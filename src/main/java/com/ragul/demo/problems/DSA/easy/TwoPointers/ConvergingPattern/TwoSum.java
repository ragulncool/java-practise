package com.ragul.demo.problems.DSA.easy.TwoPointers.ConvergingPattern;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums= new int[]{2, 7, 11, 15};
        int target = 9;
        printArray1(BF(nums,target));
        printArray1(twoPointer(nums,target));

    }



    private static void printArray1(int[] bf) {
        if (bf[0] == -1 && bf[1] == -1) {
            System.out.println("No solution found");
        } else {
            System.out.println("Indices: " + bf[0] + ", " + bf[1]);
        }
    }

    //Time Complexity: O(N) - Two Pointer, Space Complexity: O(1)
    private static int[] twoPointer(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // Return -1, -1 if no solution found
    }

    //Time Complexity: O(N^2) - Brutal Force, Space Complexity: O(1)
    private static int[] BF(int[] nums, int target) {
        //List<Integer> resultList = new ArrayList<>();
        int[] resultArr = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    // resultList.add(i);
                    // resultList.add(j);
                    resultArr[0]=i;
                    resultArr[1]=j;
                    return resultArr;
                }
            }
        }
        return resultArr;
    }
}
