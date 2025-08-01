package com.ragul.demo.problems.DSA.medium.Matrix;

public class binaryMatrixNearestZero {
    public static void main(String[] args) {
        int[][] input = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] output = new int[input.length][input[0].length];

        for (int i=0;i<input.length;i++){
            for (int j=0;j<input[0].length;j++){
                int count=0;
                if (input[i][j]==0)  output[i][j]=0;

                else{

                    int result = -1;
                    while (result!=-1) {
                        count++;
                        if (result != -1) result = checkNearestZero(i, j - 1, count, input);
                        if (result != -1) result = checkNearestZero(i, j - 1, count, input);
                        if (result != -1) result = checkNearestZero(i, j - 1, count, input);
                        if (result != -1) result = checkNearestZero(i, j - 1, count, input);
                    }

                }

            }
        }

    }

    private static int checkNearestZero(int i, int j, int count, int[][] input) {
        if (input[i][j]==0) {
            return count;
        }
        return -1;
    }
}
