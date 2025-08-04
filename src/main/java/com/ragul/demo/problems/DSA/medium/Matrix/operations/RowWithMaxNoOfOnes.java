package com.ragul.demo.problems.DSA.medium.Matrix.operations;

//Given a m x n binary matrix mat, find the 0-indexed position of the row that contains the maximum count of ones, and the number of ones in that row.
//
//        In case there are multiple rows that have the maximum count of ones, the row with the smallest row number should be selected.
//
//Return an array containing the index of the row, and the number of ones in it.
//
//
//
//        Example 1:
//
//Input: mat = [[0,1],[1,0]]
//Output: [0,1]
//Explanation: Both rows have the same number of 1's. So we return the index of the smaller row, 0, and the maximum count of ones (1). So, the answer is [0,1].
//Example 2:
//
//Input: mat = [[0,0,0],[0,1,1]]
//Output: [1,2]
//Explanation: The row indexed 1 has the maximum count of ones (2). So we return its index, 1, and the count. So, the answer is [1,2].
//Example 3:
//
//Input: mat = [[0,0],[1,1],[0,0]]
//Output: [1,2]
//Explanation: The row indexed 1 has the maximum count of ones (2). So the answer is [1,2].


//sorted
public class RowWithMaxNoOfOnes {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,1,1,1},{0,0,0,0,0},{0,1,1,1,1},{0,0,0,0,0},{0,0,1,1,1}};
        System.out.println(brutalForce(matrix));
        System.out.println(usingLowerbound(matrix));
    }



    private static int brutalForce(int[][] matrix) {
        int maxRowCount=0, indexWithMaxCount= Integer.MIN_VALUE;

        for(int i=0;i<matrix.length;i++){
            int currentRowCount=0;
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1)  currentRowCount++;
            }
            if(currentRowCount>maxRowCount){
                maxRowCount = currentRowCount;
                indexWithMaxCount = i;
            }
        }
        return indexWithMaxCount;
    }

    private static int usingLowerbound(int[][] matrix) {
        int maxRowCount=0, indexWithMaxCount= Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            int currentRowCount= matrix[0].length - lowerBound(matrix[i], matrix[0].length, 1);
            if(currentRowCount>maxRowCount){
                maxRowCount = currentRowCount;
                indexWithMaxCount = i;
            }
        }
        return indexWithMaxCount;
    }

    public static int lowerBound(int []arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
}
