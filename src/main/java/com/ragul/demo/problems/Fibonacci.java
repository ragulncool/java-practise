package com.ragul.demo.problems;

public class Fibonacci {
    //LOOPS SHOULD NOT BE USED IN RECURSION

    //0 1 1 2 3 5 8 13

    public static void main(String args[]){
        int count = 8;
       // printFibonacci(count);
        int prev=0;
        int current=1;
        int recursion=1;
//        System.out.println(prev);
//        System.out.println(current);
        recur(prev,current,recursion,count);
    }

    private static void recur(int prev, int current, int recursion, int count) { //slow
        System.out.println(prev);
        int next = 0;
        if(recursion<count){
            next = current + prev;
            //System.out.println(next);
            prev=current;
            current=next;
            recursion++;
            recur(prev,current, recursion, count);
        }
    }

    private static void printFibonacci(int count) {
        int prev=0;
        int current=1;
        System.out.println(prev);
        System.out.println(current);

        for(int i=2;i<=6;i++){
            int next = current + prev;
            System.out.println(next);
            prev=current;
            current=next;
        }
    }


}
