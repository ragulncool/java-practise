package com.ragul.demo.Graph; // Package names should be lowercase

import java.util.*;

public class BFS {

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

        List<Integer> result = bfs(grid);
        System.out.println("BFS Traversal: " + result);
    }

    static List<Integer> bfs(int[][] grid) {
        // 1. Edge case: check if grid is null or empty
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new ArrayList<>();
        }

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        List<Integer> bfsList = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        // 2. Initialize starting point
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            // Add current cell value to result
            bfsList.add(grid[r][c]);

            // 3. Explore neighbors
            for (int[] d : DIRECTIONS) {
                int nr = r + d[0];
                int nc = c + d[1];

                // Check boundaries and if already visited
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        return bfsList;
    }
}