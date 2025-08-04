package com.ragul.demo.problems.DSA.medium.Matrix.operations.Search2DMAtrixTypeII_RowColumnWIseSortedMatrix;

//type
//row in ascending roder
//column in descing order

import java.util.Arrays;
import java.util.List;

//TC O(m+n) space O(1)
public class searchInMatrixTypeII {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target=14;

        System.out.println( doSearch(matrix,target));
    }

    private static List<Integer> doSearch(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        // Start from the top-right corner or bottom left corner
        int rowIndex = 0, columnIndex = colLen-1;
        //we can use the opp also

        while (rowIndex < rowLen && columnIndex >= 0) {
            if(matrix[rowIndex][columnIndex]==target){
                return Arrays.asList(rowIndex,columnIndex);
            } else if (matrix[rowIndex][columnIndex] < target) {
                rowIndex++; //                // Move down if the current value is less than the target

            }else{
                columnIndex--;  //  // Move left if the current value is greater than the target
            }
        }
        return Arrays.asList(-1,-1);
    }
}
