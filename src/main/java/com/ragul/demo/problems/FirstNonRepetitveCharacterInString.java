package com.ragul.demo.problems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepetitveCharacterInString {
    public static void main(String[] args) {
        String str = "abaccb";
        System.out.println("First non-repetitive character in string: " + findFirstNonRepetitiveCharacter(str));
    }

    private static Character findFirstNonRepetitiveCharacter(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>(); //for maintaining insertion order
        char[] c = s.toCharArray();
        Character firstNonRepChar = null;
        for (int i=0;i<c.length;i++){
            if(map.containsKey(c[i])){
                Integer count = map.get(c[i]);
                map.put(c[i],count+1);
            }else{
                map.put(c[i],1);
            }
            if(checkFirstNonRepetitiveCharacter(map, c[i]) !=null){
                firstNonRepChar = checkFirstNonRepetitiveCharacter(map, c[i]);
            }
        }
        return firstNonRepChar;
    }

    private static Character checkFirstNonRepetitiveCharacter(Map<Character, Integer> map, char c) {
        for (Character key: map.keySet()){
            if(map.get(key) == 1){
                System.out.println("First non-repetitive character is: " + key);
                return key;
            }
        }
        System.out.println("No non-repetitive character found.");

        return null;
    }
}
