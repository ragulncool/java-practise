package com.ragul.demo.problems.DSA.medium.Matrix;

import java.io.*;

//Time Complexity:O(n)
//The function printZShape prints elements from the first row (n), the diagonal (n-2), and the last row (n), totaling O(n) operations for an n x n matrix.
//Space Complexity:O(1)
//No extra space is used except for a few variables; the matrix is only read, not modified.
public class printMatrixInZOrder {

    public static void printZShape(int[][] matrix, int n) {
        // Phase 1: Print the first row
        for (int j = 0; j < n; j++) {
            System.out.print(matrix[0][j] + " ");
        }

        // Phase 2: Print the right diagonal
        // Start from (1, n-2) and go down-left
        for (int i = 1; i < n - 1; i++) {
            System.out.print(matrix[i][n - 1 - i] + " ");
        }

        // Phase 3: Print the last row
        if (n > 1) { // Only print last row if more than one row exists
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[n - 1][j] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] myMatrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int size = 4;

        System.out.println("The matrix in Z-order is:");
        printZShape(myMatrix, size);
    }
}
