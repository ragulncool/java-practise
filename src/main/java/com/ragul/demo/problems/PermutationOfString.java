package com.ragul.demo.problems;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=GuTPwotSdYw
public class PermutationOfString {
     //Function for swapping the characters at position I with character at position j
        public static String swapString(String a, int i, int j) {
            char[] b =a.toCharArray();
            char ch;
            ch = b[i];
            b[i] = b[j];
            b[j] = ch;
            return String.valueOf(b);
        }

        public static void main(String[] args)
        {
            String str = "ABC";
            int len = str.length();
            List<String> totalPermutedStrings = new ArrayList<>();
            System.out.println("All the permutations of the string are: ");
            totalPermutedStrings = generatePermutation(str, 0, len-1, totalPermutedStrings);
            System.out.println("Total permutations: "+totalPermutedStrings.size());

        }

        //Function for generating different permutations of the string
        public static List<String> generatePermutation(String str, int start, int end, List<String> totalPermutedStrings)
        {
            //Prints the permutations
            if (start == end) {
                System.out.println(str+ " start and end " +start+" "+end);
                totalPermutedStrings.add(str);
            }else
            {
                for (int i = start; i <= end; i++)
                {
                    //Swapping the string by fixing a character
                    System.out.println("Swap "+start+" with "+i);
                    str = swapString(str,start,i);
                    //Recursively calling function generatePermutation() for rest of the characters
                    generatePermutation(str,start+1,end,totalPermutedStrings);
                    //Backtracking and swapping the characters again.
                    str = swapString(str,start,i);
                }
            }
            return totalPermutedStrings;
        }
    }

