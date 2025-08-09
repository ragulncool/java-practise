package com.ragul.demo.problems.Collections.String;

public class IsSubsequence {
    public static void main(String[] args) {
        String[] s={"abc","axc"};
        String[] t={"ahbgdc","ahbgdc"};
        for (int i=0;i<s.length;i++){
            System.out.println(isSubsequence(s[i],t[i]));
        }

    }

    private static boolean isSubsequence(String s, String t) {
        if(t.length()<s.length()) return false;

        int sPtr=0, tPtr=0;
        while (sPtr<s.length() && tPtr<t.length()){
            if(s.charAt(sPtr)==t.charAt(tPtr)){
                sPtr++;
                tPtr++;
            }else{
                tPtr++;
            }
        }
        return sPtr==s.length();
    }
}
