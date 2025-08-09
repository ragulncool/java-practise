package com.ragul.demo.problems.Collections.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicString {
    public static void main(String[] args) {
        String[] s = {"egg","foo","ab"}; //a->c, b>c
        String[] t = {"add","bar","cc"};//but not imverse c->a
        for(int i=0;i<s.length;i++){
            System.out.println(check(s[i], t[i]));
        }
    }

    private static boolean check(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i=0;i<s.length();i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);


            if(sMap.containsKey(s1) && !sMap.get(s1).equals(t1))
                       return false;
            if(tMap.containsKey(t1) && !tMap.get(t1).equals(s1))
                        return false;
            sMap.put(s1,t1);
            tMap.put(t1,s1);
        }
        return true;
    }
}
