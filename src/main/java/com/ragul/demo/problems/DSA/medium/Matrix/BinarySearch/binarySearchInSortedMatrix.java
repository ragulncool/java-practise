package com.ragul.demo.problems.DSA.medium.Matrix.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class binarySearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{3,4,7,9},{12,13,16,18},{20,21,23,29}};
        int target = 16;

        //brutal
        //O(mxn), Space(1)

        //BINARY SEARCH
        System.out.println(BS(matrix,target));
    }

//    Time: O(log(m × n))
//    Space: O(1)
    private static List<Integer> BS(int[][] matrix, int target) {
        List<Integer> indexList = new ArrayList<>();

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        //vistual representation of 2D matrix as 1D array .  doing relaistic will get again )(mxn) hence doing virtually
        int lowIndex=0, highIndex = rowLen * colLen - 1;
        while (lowIndex<=highIndex){
            int midIndex = (lowIndex+highIndex)/2;

            int midLowMatrixIndex = midIndex / colLen;
            int midHighMatrixIndex = midIndex % colLen;


            int midValue = matrix[midLowMatrixIndex] [midHighMatrixIndex];
            if(midValue==target){
                return Arrays.asList(midLowMatrixIndex,midHighMatrixIndex);
            }else if(target < midValue){
                highIndex = midIndex - 1;
            }else {
                lowIndex = midIndex + 1;
            }
        }

        return Arrays.asList(-1,-1);
    }
}
