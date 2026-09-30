package com.ragul.demo.problems.DSA.DataStructures.Stack;

public class Test_StackUsingArray{
    public static void main(String args[]){
        StackUsingArray s = new StackUsingArray(10);
        System.out.println(s.push(1));
        System.out.println(s.push(2));
        System.out.println(s.push(4));
        System.out.println(s.push(7));

        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s);
    }
}

class StackUsingArray{
    int[] s= new int[10]; // do intiialization at constructor
    int maxCapacity; // no need
    int top;

    public StackUsingArray(int maxCapacity) {
        this.maxCapacity=maxCapacity; //no need. directly do s= new int[maxCapacity]
        top=-1;
    }


    public boolean push(int data) {
        if(top >= maxCapacity-1){
            System.out.println("Stack Overflow");
            return false;
        }else{
            top=top+1;
            s[top]=data;
            return true;
        }

    }

    public int peek() {
        if(top<0){
            System.out.println("Stack Underflow");
            return -1;
        }else {
            return s[top];
        }
    }

    public int pop() {
        if(top<0){
            System.out.println("Stack Underflow");
            return 0;
        }else {

                return s[top--]; //return and decrement
        }
    }

    public boolean isEmpty() {
//        if(top<0){
//            return true;
//        }else{
//            return false;
//        }
        //simplified
        return top<0;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = top; i >= 0; i--) {
            sb.append(s[i]).append(" ");
        }
        return sb.toString();
    }


}