package com.ragul.demo.problems.DSA.medium.Matrix;

//O(n2) and space O(1) since len constant
public class PrintMatrixInZOrder {
    public static void main(String args[]){
//        int[][] matrix ={
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };

        int[][] matrix ={
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

        int len=matrix.length;
        for(int i=0;i<len;i++, System.out.println()) {
            for (int j = 0; j < len; j++) {
                if (i == 0 || i==len-1) {
                    System.out.print(matrix[i][j]+" ");
                }else{
                    if(j==(len-1)-i){
                        System.out.print(matrix[i][j]+" ");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
        }

    }
}
