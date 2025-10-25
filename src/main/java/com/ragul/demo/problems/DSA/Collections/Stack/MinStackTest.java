package com.ragul.demo.problems.DSA.Collections.Stack;

import java.util.Stack;

public class MinStackTest {
    public static void main(String[] args) {
        Stack2_withMin minStack=new Stack2_withMin();
        minStack.push(-2);         System.out.println(minStack.peek()+" "+minStack.getMin());
        minStack.push(2);           System.out.println(minStack.peek()+" "+minStack.getMin());
        minStack.push(-3);              System.out.println(minStack.peek()+" "+minStack.getMin());
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
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public int peek() {
        return stack.peek();
    }
}
