package com.ragul.demo.problems.DSA.Collections.Recursion;

//time O(n) - one swap per pair
//extar memory is sued -stack
//hence memory is always O(n)
public class ReverseString_useTwoPointer {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        reverseString12(0,arr.length-1,arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void reverseString12(int i, int j, int[] arr) {
        if(i>=j) return;

        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

        reverseString12(i+1,j-1, arr);
    }


}
