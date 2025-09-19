package com.ragul.demo.problems.DSA.medium.Matrix;

import java.util.ArrayList;
import java.util.List;



//Time Complexity: O(m*n) where m is the number of rows and n is the number of columns in the matrix.
    //The code iterates through every element twice: once to find zeros, once to set zeros.
//Space Complexity: O(m+n) for storing the row and column indices of zeros.
    // This solution uses two lists to keep track of which rows and columns need to be set to zero.

//we can optimize this further to O(1) space by using the first row and first column of the matrix itself to mark zeros, but that would require additional checks to avoid overwriting the first row and column values.
// This solution is simpler and easier to understand, especially for beginners.
//Use the first row and column to mark zeros.
//        Track if the first row/column originally had zeros.
//       Set matrix cells to zero based on markers.
public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix_1 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeros(matrix);
        printMatrix(matrix);


        setZerosWith_ConstSpace(matrix_1);
        printMatrix(matrix_1);

    }

    private static void printMatrix(int[][] matrix) {
        for (int i=0;i<matrix.length;i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }


    private static void setZeros(int[][] matrix) {
//        int m = matrix.length, n = matrix[0].length;
//        boolean firstRowZero = false, firstColZero = false;
//
//        // Check if first row has zero
//        for (int j = 0; j < n; j++) {
//            if (matrix[0][j] == 0) firstRowZero = true;
//        }
//        // Check if first column has zero
//        for (int i = 0; i < m; i++) {
//            if (matrix[i][0] == 0) firstColZero = true;
//        }

        List<Integer> zeroRowList = new ArrayList<>();
        List<Integer> zeroColumnList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 0) {
                    zeroRowList.add(i);
                    zeroColumnList.add(j);
//                    matrix[0][j] = 0; firstRowZero = true;
//                    matrix[i][0] = 0; firstColumnZero = true;
                }

            }
        }

//        // Set first row to zero if needed
//        if (firstRowZero) {
//            for (int j = 0; j < n; j++) matrix[0][j] = 0;
//        }
//        // Set first column to zero if needed
//        if (firstColZero) {
//            for (int i = 0; i < m; i++) matrix[i][0] = 0;
//        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (zeroRowList.contains(i) || zeroColumnList.contains(j)) {
                    matrix[i][j] = 0;
                }

            }
        }

    }

    private static void setZerosWith_ConstSpace(int[][] matrix) {

        boolean firstRowZero=false, firstColumnZero=false;

        // Step 1: check first row & col
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) firstRowZero = true;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) firstColumnZero = true;
        }

        //use first row and column as memory instead of seperate space
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //set zeros based on first row or first column value
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0]==0) {
                   matrix[i][j]=0;
                }
            }
        }

        // Step 4: handle first row
        if (firstRowZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 5: handle first col
        if (firstColumnZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }




    }


}
