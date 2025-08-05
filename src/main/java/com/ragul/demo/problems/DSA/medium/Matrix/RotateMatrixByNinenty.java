package com.ragul.demo.problems.DSA.medium.Matrix;

//rotate right side 90
public class RotateMatrixByNinenty {
    public static void main(String[] args) {
        int[][] matrix ={
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

        //TRANSPOSE
        int len=matrix.length;
        for(int i=0;i<len;i++) {
            for (int j = i+1; j < len; j++) {  //j>1
                int temp;
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        // Step 2: Reverse each row
        // Step 2: Reverse each row using for loop
        for (int i = 0; i < len; i++) {
            for (int left = 0, right = len - 1; left < right; left++, right--) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
        }

        //alternate
        // Step 2: Reverse each row
//        for (int i = 0; i < n; i++) {
//            int left = 0, right = n - 1;
//            while (left < right) {
//                // Swap elements in the row
//                int temp = matrix[i][left];
//                matrix[i][left] = matrix[i][right];
//                matrix[i][right] = temp;
//                left++;
//                right--;
//            }
//        }

        for(int i=0;i<len;i++, System.out.println()) {
            System.out.println();
            for (int j = 0; j < len; j++) {
                System.out.print(matrix[i][j]+" ");
            }
        }
    }
}
