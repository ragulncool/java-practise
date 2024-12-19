package com.ragul.demo.problems;

import java.util.Arrays;

public class twoDArray {

    public static void main(String args[]){
        int[][] a=new int[3][3]; //by default all values will be 0

        int[][] b = { { 1, 2, 3 }, { 4, 5, 6 } ,{7,8,9}};
        printArray(b);



        printArray(a);
       // Arrays.fill(a,"*"); - not working for 2D array. fill row wise

        for (int[] row: a) { //using enhanced for to iterate rows
            Arrays.fill(row, 3);
        }
        printArray(a);


        for(int i=0;i< a.length;i++){ //using conventional for to iterate rows
            Arrays.fill(a[i],i);
        }

        //or Arrays.fill(arr[0], 3);
        printArray(a);

        //arr[0][0] = 1;
        findMaxSumAndMaxSumRow(a);

    }

    static void printArray(int[][] a){
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }

    static void findMaxSumAndMaxSumRow(int[][] a){
        int maxRowSum=0;
        int maxRowIndex=-1;
        for (int i=0;i<a.length;i++){
            int rowSum=0;
            for (int j=0;j<a.length;j++){
                rowSum=rowSum+a[i][j];
            }
            if(rowSum>maxRowSum){
                maxRowSum=rowSum;
                maxRowIndex=i;
            }
            System.out.println("");
        }
        System.out.println("maxRowSum:"+maxRowIndex+" maxRowIndex:"+maxRowIndex);
    }
}
