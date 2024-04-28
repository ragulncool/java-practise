package com.ragul.demo.problems;

public class MergeSortedArray {

    // new array, length = arr1 + arr2 length
    //  copy arr1 to new arr, arr1.length-1 to arr1.lenth+arr2.length-1
    //


    public static void main(String args[]){
        int[] a1 = {1,2,3,4};
        int[] a2 = {7,8,9,10};
        int[] mergedArray = new int[a1.length+a2.length];
//        for(int i=0;i<a1.length;i++){
//            mergedArray[i]=a1[i];
//        }
//
//        for(int i=a1.length,j=0;i<mergedArray.length;i++,j++){
//            mergedArray[i]=a2[j];
//        }
//        //print Array
//        for(int d: mergedArray){
//            System.out.println(d);
//        }

        for(int i=0;i<mergedArray.length;i++){
            if(i<a1.length){
                mergedArray[i]=a1[i];
            }else{
                mergedArray[i]=a2[i-a1.length];
            }
            System.out.println(mergedArray[i]);

        }
    }
}
