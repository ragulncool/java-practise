package com.ragul.demo.problems;

//Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
//        Output: gee
//        Explanation: "gee" is the longest common prefix in all the given strings.

import java.util.Arrays;

//        Input: arr[] = ["hello", "world"]
//        Output: -1
//        Explanation: There's no common prefix in the given strings.
public class LongestCommonPrefix {
    public static void main(String args[]) {
        String arr[]={"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println("LONGEST COMMON PREFIX : "+findLongestCommonPrefix(arr));
    }

    private static String findLongestCommonPrefix(String[] arr) {
        Arrays.sort(arr);
        String longPrefix="";
        String checkPrefix="";

        for (int j=arr[0].length();j>=0;j--) {
            checkPrefix = arr[0].substring(0,j);
            System.out.println("checking prefix "+checkPrefix);

            for (int i=1;i<arr.length;i++){
                    if(arr[i].substring(0,j).equals(checkPrefix)){
                        if(i==arr.length-1){
                            return checkPrefix;
                        }
                    continue;
                }else{
                        System.out.println(checkPrefix+" not present ");
                        break;
                }
            }
        }

        return longPrefix;
    }
}