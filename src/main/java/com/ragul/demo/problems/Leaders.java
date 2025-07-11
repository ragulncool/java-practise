package com.ragul.demo.problems;

import java.util.ArrayList;
import java.util.List;

public class Leaders {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
       System.out.println(findLeaders(arr));
    }



    private static List<Integer> findLeaders(int[] arr) {

        List<Integer> leaderList = new ArrayList<>();
        int max = arr[arr.length - 1];
        leaderList.add(max);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                leaderList.add(arr[i]);
                max = arr[i];
            }
        }

        // Print leaders in reverse order to maintain original order
        for (int i = leaderList.size() - 1; i >= 0; i--) {
            System.out.print(leaderList.get(i) + " ");
        }
        return leaderList;
    }

//    private static List<Integer> findLeaders1(int[] arr) {
//        int i=arr.length-2, max=arr[arr.length-1];
//        List<Integer> leaderList = new ArrayList<>();
//
//        leaderList.add(arr[arr.length-1]);
//
//        for (i=arr.length-2;i>=0;i--){
//            if (arr[i]>max){
//                leaderList.add(arr[i]);
//                max=arr[i];
//            }
//        }
//        return leaderList;
//    }
}
