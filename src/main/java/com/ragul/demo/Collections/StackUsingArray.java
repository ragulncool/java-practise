package com.ragul.demo.Collections;

public class StackUsingArray{
    public static void main(String args[]){
        Stack1 s = new Stack1(10);
        System.out.println(s.push(1));
        System.out.println(s.push(2));
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s);
    }
}

class Stack1{
    int[] s= new int[10];
    int maxCapacity;
    int top;

    public Stack1(int maxCapacity) {
        this.maxCapacity=maxCapacity;
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
            return 0;
        }else {
            return s[top];
        }
    }

    public int pop() {
        if(top<0){
            System.out.println("Stack Underflow");
            return 0;
        }else {
                s[top] = 0;
                top = top - 1;
                return s[top];
        }
    }

    public boolean isEmpty() {
        if(top<0){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        int temp=top;
        while(temp>=0 && temp<s.length){

           System.out.println(s[temp]);
           temp--;
        }
        return "";
    }
}