package com.ragul.demo.problems.DSA.DataStructures.Stack;

import java.util.Stack;

public class MinStackTest {
    public static void main(String[] args) {
        Stack2_withMin stacks=new Stack2_withMin();
        stacks.push(3);         System.out.println(stacks.peek()+" "+stacks.getMin());
        stacks.push(2);           System.out.println(stacks.peek()+" "+stacks.getMin());
        stacks.push(5);              System.out.println(stacks.peek()+" "+stacks.getMin());
        System.out.println(stacks.pop());
        System.out.println(stacks.peek());
    }
}

class Stack2_withMin {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public Stack2_withMin() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // Push onto minStack if it's the new minimum

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public int pop() {
        if (stack.isEmpty()){
            System.out.println("Stack underflow");
            return -1;
        }
        if (stack.peek().equals(minStack.peek())) { //ele peek element > minstack.peek
            minStack.pop();
        }
        return stack.pop();
    }


    public int getMin() {
        if (minStack.isEmpty()){
            System.out.println("Stack underflow");
            return -1;
        }
        return minStack.peek();
    }

    public int peek() {
        if (stack.isEmpty()){
            System.out.println("Stack underflow");
            return -1;
        }
        return stack.peek();
    }

}
