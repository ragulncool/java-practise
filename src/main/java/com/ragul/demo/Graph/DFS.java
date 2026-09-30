package com.ragul.demo.Graph; // Package names should be lowercase

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFS {

    //Down, Up, Right, Left

    // Defined directions as a constant: Down, Up, Right, Left
    private static final int[][] DIRECTIONS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> result = dfs(grid);
        System.out.println("DFS Traversal: " + result);
    }

    static List<Integer> dfs(int[][] grid) {
        // 1. Edge case: check if grid is null or empty
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new ArrayList<>();
        }

        int m = grid.length;
        int n = grid[0].length;

        List<Integer> bfsList = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];


        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                dfsHelper(grid, i, j, visited, bfsList);
            }
        }

        return bfsList;
    }

    private static void dfsHelper(int[][] grid, int i, int j, boolean[][] visited, List<Integer> bfsList) {
        int m = grid.length;
        int n = grid[0].length;

        // Check boundaries and if already visited
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }

        // Mark the cell as visited and add to result
        visited[i][j] = true;
        bfsList.add(grid[i][j]);

        // Explore neighbors
        for (int[] d : DIRECTIONS) {
            int ni = i + d[0];
            int nj = j + d[1];
            dfsHelper(grid, ni, nj, visited, bfsList);
        }
    }
}