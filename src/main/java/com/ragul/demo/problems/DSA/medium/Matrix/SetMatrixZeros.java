package com.ragul.demo.problems.DSA.medium.Matrix;

import java.util.ArrayList;
import java.util.List;



//Time Complexity: O(m*n) where m is the number of rows and n is the number of columns in the matrix.
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
        setZeros(matrix);

        for (int i=0;i<matrix.length;i++){
            for(int j=0; j<matrix.length; j++){
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
            for (int j = 0; j < matrix.length; j++) {

                if (matrix[i][j] == 0) {
                    zeroRowList.add(i);
                    zeroColumnList.add(j);
//                    matrix[i][0] = 0;
//                    matrix[0][j] = 0;
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
            for (int j = 0; j < matrix.length; j++) {

                if (zeroRowList.contains(i) || zeroColumnList.contains(j)) {
                    matrix[i][j] = 0;
                }

            }
        }

    }

}
