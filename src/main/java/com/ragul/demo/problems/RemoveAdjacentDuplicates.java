package com.ragul.demo.problems;

public class RemoveAdjacentDuplicates {
    public static void main(String args[]){
        String s="heeeelllooo worrrllldddeeeeee";
        removeAdjacentDuplicates(s);
    }

    private static void removeAdjacentDuplicates(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();//        char[] uniqueChars = new char[chars.length];

        for(int i=0, uRow=0;i<chars.length;i++){
            if (i==chars.length-1 || chars[i] != chars[i+1]) {
               sb.append(chars[i]); //uniqueChars[uRow]=chars[i];
                ++uRow;
            }else{
                System.out.println("i and i+1 are equal "+chars[i]);
            }
        }

//        for(int i=0;i<uniqueChars.length;i++){
//            System.out.print(uniqueChars[i]);
//        }
        System.out.print(sb); //else outut will be helo world box box since we allocate memory for array and nothing isnide

    }
}
