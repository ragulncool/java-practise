package com.ragul.demo.Graph;
//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//
//
//Example 1:
//
//Input: grid = [
//        ["1","1","1","1","0"],
//        ["1","1","0","1","0"],
//        ["1","1","0","0","0"],
//        ["0","0","0","0","0"]
//        ]
//Output: 1
//Example 2:
//
//Input: grid = [
//        ["1","1","0","0","0"],
//        ["1","1","0","0","0"],
//        ["0","0","1","0","0"],
//        ["0","0","0","1","1"]
//        ]
//Output: 3
public class RottingTomatoes {
    public static void main(String[] args) {
//        int[][] nums = new int[][]{{1,1,1,1,0},
//                {1,1,0,1,0},
//                {1,1,0,0,0},
//                {0,0,0,0,0}};
        int[][] nums = new int[][]{{2,1,1},
                {1,1,0,},
                {0,1,1}};
        int minuteCount=0;

        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums[0].length;j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }

        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums[0].length;j++){
                if(nums[i][j]!=0){
                    nums = markZero(nums,i,j,minuteCount);
                }
            }
        }

        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums[0].length;j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
//        System.out.println(islandCount);
    }

    private static int[][] markZero(int[][] nums, int i, int j, int minuteCount) {


        if(i<0 || j<0 || i>nums.length-1 || j>nums[0].length-1){
            return nums;
        }

        if (nums[i][j]==0){
            return nums;
        }else{
            nums[i][j]=0;
        }

        markZero(nums,i-1,j, minuteCount);
        markZero(nums,i+1,j, minuteCount);
        markZero(nums,i,j-1, minuteCount);
        markZero(nums,i,j+1, minuteCount);

        return nums;
    }
}
