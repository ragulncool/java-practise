package com.ragul.demo.problems;

import java.util.Arrays;

public class twoDArray {

    public static void main(String args[]){
        int[][] a=new int[3][3];

        int[][] b = { { 1, 2, 3 }, { 4, 5, 6 } ,{7,8,9}};
        printArray(b);



        printArray(a);
       // Arrays.fill(a,"*"); - not working for 2D array. fill row wise

        for (int[] row: a) {
            Arrays.fill(row, 3);
        }

        //or Arrays.fill(arr[0], 3);
        printArray(a);

        //arr[0][0] = 1;
    }

    static void printArray(int[][] a){
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
