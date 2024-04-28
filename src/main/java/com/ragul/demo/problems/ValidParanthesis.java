package com.ragul.demo.problems;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String args[]){
        String s="[{]}]";
        System.out.println(isParBalanced(s.toCharArray()));
    }

    private static boolean isParBalanced(char[] c) {
        Stack s = new Stack();
        for(int i=0;i<c.length;i++){
            if(c[i]=='}'){
                if(s.isEmpty() || !s.pop().equals('{')){ //chekcing for is empty becuase first can be closing cha or opening might not be present
                   return false; //not equals is when closing an dopening mismatches
                }
            }else if(c[i]==']'){
                if(s.isEmpty() || !s.pop().equals('[')){
                    return false;
                }
            }else if(c[i]==')'){
                if(s.isEmpty() || !s.pop().equals('(')){
                    return false;
                }
            }else{
                s.push(c[i]);
            }
        }

        return true;
    }
}
