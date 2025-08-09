package com.ragul.demo.problems.Collections.String.RemoveOutermostParanthesis;

public class RemoveOutermostParanthesis {
    public static void main(String[] args) {
        String[] s={"(()())(())","(()())(())(()(()))"};
        for (int i=0;i<s.length;i++){
            System.out.println(removeParanthesis(s[i]));
        }
    }

    private static StringBuilder removeParanthesis(String s) {
        StringBuilder result = new StringBuilder("");
        int balance = 0; //// track depth

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if (balance>0) result.append(s.charAt(i)); // only add if we're not at the outermost level

                balance++;
            }
            else{
                balance--;
                if (balance>0) result.append(s.charAt(i)); // only add if we're not at the outermost level

            }
        }


        return result;
    }
}
