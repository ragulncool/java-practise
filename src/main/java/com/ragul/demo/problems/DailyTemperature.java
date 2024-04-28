package com.ragul.demo.problems;

// FRESHWORKS
//
//Given an array of integers temp represents the daily temperatures, return an array arr such that arr[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep arr[i] == 0 instead.
//
//        Example 1:
//
//        Input: temp = [73,74,75,71,69,72,76,73]
//        Output arr: [1,1,4,2,1,1,0,0]
//        Example 2:
//
//        Input: temp = [30,60,90]
//        Output arr: [1,1,0]
public class DailyTemperature {

    public static void main(String args[]) {
       // int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temp = {73, 75,71, 82,90, 72, 76, 88};
        int[] days = new int[temp.length];
        for (int i = 0; i < temp.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < temp.length; j++) {
                count = count + 1;
                if (temp[j] > temp[i]) {
                    days[i] = count;
                    break;
                }
            }
            System.out.println(days[i]);
        }
       days[temp.length - 1] = 0; //last element will always be 0
        System.out.println(days[temp.length - 1]);
    }
}
