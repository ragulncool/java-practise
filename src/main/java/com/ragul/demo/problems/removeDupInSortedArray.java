package com.ragul.demo.problems;

public class removeDupInSortedArray {
    public static void main(String args[]){
        int[] arr = {1,1,2,2,4,5,5,5,6};
        int[] uniqueArr=new int[arr.length];
        int[] dupArr=new int[arr.length];
        int j=0;
        int l=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=arr[i+1]){
                uniqueArr[j]=arr[i]; j++;
            }
        }
        uniqueArr[j]=arr[arr.length-1];
        for(int k:uniqueArr){
            System.out.println(k);
        }

    }
}
//if want to change original array at end, copy everything from uniqueArr to original arr at end of program
