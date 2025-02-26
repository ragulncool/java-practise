package com.ragul.demo.problems;

public class Fibonacci {
    //LOOPS SHOULD NOT BE USED IN RECURSION

    //0 1 1 2 3 5 8 13

    public static void main(String args[]){
        int count = 8;
        int prev=0;
        int current=1;
        int recursion=1;
//        System.out.println(prev);
//        System.out.println(current);

        long start = System.nanoTime(); //no diff in millisecs. ehcen going for nano
        printUsingRecursion(prev,current,recursion,count); //recursion is slower
        long end = System.nanoTime();
        System.out.println(end-start);
        System.out.println();

         start = System.nanoTime();
        printUsingFor(count);
         end = System.nanoTime();
        System.out.println(end-start);


    }

    private static void printUsingRecursion(int prev, int current, int recursion, int count) { //slow
        System.out.print(prev+" ");
        int next = 0;
        if(recursion<count){
            next = current + prev;
            //System.out.println(next);
            prev=current;
            current=next;
            recursion++;
            printUsingRecursion(prev,current, recursion, count);
        }
    }

    private static void printUsingFor(int count) {
        int prev=0;
        int current=1;
        System.out.print(prev+" ");
        System.out.print(current+" ");

        for(int i=2;i<count;i++){
            int next = current + prev;
            System.out.print(next+" ");
            prev=current;
            current=next;
        }
    }


}
