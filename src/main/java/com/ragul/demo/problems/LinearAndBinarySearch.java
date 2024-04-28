package com.ragul.demo.problems;

import java.util.Arrays;

public class LinearAndBinarySearch {
    public static void main(String args[]){
        int[] num={1,2,5,2,7,6};
        int searchItem=5;

        //linear search O(N)
        for(int i=0;i<num.length;i++){
            if(searchItem==num[i]){
               System.out.println("position "+i);
            }
        }

        //binary search - CAN BE DONE ONLY FOR SORTED ARRAY O(LOG N)
        Arrays.sort(num);
        int pos = doBinarySearch(num, searchItem, 0, num.length - 1);
        System.out.println("position "+pos);

    }

    private static int doBinarySearch(int[] n, int searchItem, int start, int end) {
        int mid=n.length/2;
        for(int i=start;i<=end;i++){
            if(searchItem==n[mid]){
                return mid;
            }else if(searchItem < n[mid]){
                return doBinarySearch(n,searchItem,start,mid-1);
            }else if(searchItem > n[mid]){
                return doBinarySearch(n,searchItem,mid+1,end);
            }
        }
        return -1;
    }
}
