package com.ragul.demo.problems;

import java.util.Arrays;

//https://leetcode.com/problems/candy/?envType=study-plan-v2&envId=top-interview-150
public class Candy {
    public static void main(String args[]) {
            int ratings[] = {1,0,2};
        int candies[] = new int[ratings.length];
        int l[] = new int[ratings.length];
        int r[] = new int[ratings.length];
        int sum=0;

        Arrays.fill(l,1);
        Arrays.fill(r,1);



        for(int i=1;i<ratings.length;i++){ //1 to n-1
            if(ratings[i]>ratings[i-1]){
                l[i]=l[i-1]+1;
            }
        }

        printArray(l);

        for(int i=ratings.length-2;i>=0;i--){//0 to n-2
            if(ratings[i]>ratings[i+1]){
                r[i]=r[i+1]+1;
            }
        }

        printArray(r);

        for(int i=0;i<candies.length;i++){
            candies[i]=Math.max(l[i],r[i]);
            sum=sum+candies[i];
        }
        printArray(candies);
        System.out.println(sum);

    }

    private static void printArray(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }


}