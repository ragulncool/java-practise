package com.ragul.demo.problems;


import org.springframework.util.StringUtils;

//Input:
//        a = amazon
//        b = azonam
//        Output:
//        1
//        Explanation:
//        amazon can be rotated anti-clockwise by two places, which will make it as azonam.
public class StringRotatedByTwoStrings {
    public static void main(String args[]){
        String str = "Hello world";
        System.out.println("Is StringRotatedByTwoStrings? "+checkRotate(str));
    }

    private static boolean checkRotate(String str) {
        char[] chars = str.toCharArray();
        char[] rotChars = str.toCharArray();

        rotChars[0]=chars[str.length()-1];
        rotChars[1]=chars[str.length()-2];

        for(int i=0;i<str.length()-2;i++){
            rotChars[i+2]=chars[i];
        }

        for(int i=0;i<str.length();i++){
            System.out.print(rotChars[i]);
        }
        if(StringUtils.pathEquals(str, rotChars.toString())){
            return true;
        }else{
            return false;
        }
    }
}
