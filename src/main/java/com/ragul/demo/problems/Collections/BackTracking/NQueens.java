package com.ragul.demo.problems.Collections.BackTracking;

import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        int n=4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solveNQueens(0,board);
    }

    static void solveNQueens(int row, char[][] board) {
        if (row == board.length) {
            printBoard(board);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';   // place queen
                solveNQueens(row + 1,board);  // recurse
                board[row][col] = '.';  // backtrack
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int n=board.length;

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private static void printBoard(char[][] board) {
        System.out.println("SOLUTION");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }




}
