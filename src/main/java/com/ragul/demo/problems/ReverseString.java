package com.ragul.demo.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String args[]){
        System.out.println("===USING REVERSE METHOD IN STRINGBUFFER===");
        String s="hello world";
        System.out.println(checkPalindrome(s));

        System.out.println("===USING REVERSE METHOD IN STRINGBUFFER with Streams===");
        List<String> strings = Arrays.asList("racecar", "hello", "A man a plan a canal Panama", "world", "madam", "Java");
        List<String> palindromes = strings.stream().filter(ReverseString::checkPalindrome).collect(Collectors.toList());
        System.out.println(palindromes);
        
        System.out.println("===METHOD 1 .WITHOUT USING REVERSE===");
        char[] chars = s.toCharArray();
        char[] reversedChars = new char[chars.length];
        for(int i=0;i<chars.length;i++){
            reversedChars[(chars.length-1)-i]=chars[i];
        }
        for(int i=0;i<chars.length;i++){
            System.out.print(reversedChars[i]);
        }

        System.out.println();
        System.out.println("===METHOD 2 .WITHOUT USING REVERSE===");
        char temp;
        for(int i=0;i<chars.length / 2;i++){ //NEED TO REVER ONLY HALF ELSE STRING WILL BE TWICE REVERSE WHICH WILL BE SAME
            temp =  chars[i];
            chars[i]=chars[(chars.length-1)-i];
            chars[(chars.length-1)-i]=temp;
        }
        for(int i=0;i<chars.length;i++){
            System.out.print(chars[i]);
        }


    }

    private static boolean checkPalindrome(String s) {
        StringBuffer stringBuffer = new StringBuffer(s);
        stringBuffer = stringBuffer.reverse();
        return s.equals(stringBuffer.toString());
    }
}
