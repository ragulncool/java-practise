package com.ragul.demo.Stack;


import java.util.Stack;
//https://leetcode.com/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150
public class Simplifypath {
    public static void main(String args[]) {
     //String path="one\\\\\\two\\\\three\\four\\\\..\\five";
     String path = "/.../a//../b/c///../d/./";
        simplifypath(path);
    }

    private static void simplifypath(String path) {

        //validation - replace // and /// by /
        String splitter = "/";     //"\\\\"

        path=  path.replace(splitter+splitter+splitter,splitter);
        path=  path.replace(splitter+splitter,splitter); //after replacing long char


        System.out.println("Corrected Path "+path);

        //push valid names except . and "" to stack
                      String[] paths = path.split(splitter);
                      Stack s = new Stack();
                      for(String eachPath:paths){
                          if(eachPath.equals("..")){
                              s.pop();
                          }else if(!eachPath.equals(".") && !eachPath.equals("")){
                              s.push(eachPath);
                          }
                      }


                      //stack print directory in reverse, to overcome inserting in new stack and popping - check - others didnt do
                      Stack s1 = new Stack();
                      while (!s.isEmpty()){
                          s1.push(s.pop());
                      }

                     System.out.println(s1);

                      while (!s1.isEmpty()){
                          System.out.print(splitter);
                          System.out.print(s1.pop());
                      }

    }
}