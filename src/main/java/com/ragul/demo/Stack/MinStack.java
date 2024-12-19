package com.ragul.demo.Stack;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

//challenge - if we keep single variable min  for comparing and storing during push, problem comes during pop
//when min element is popped, new min element should be updated in MIN var

//new logic

import java.util.Stack;

public class MinStack{
    Stack<Integer> stack =new Stack<>();
    int min;

    public void checkAndPush(int i) {
        if(stack.isEmpty()){
            stack.push(i);
            min=i;
        }else if(i<min){
            stack.push((2*i)-min);
            min=i;
        }else{
            stack.push(i);
        }
    }

    public int checkAndPop() {
        if(stack.isEmpty()){
            min=0;
            return -1;
        }else if(stack.peek()<min){
            Integer removedEle = stack.pop();
            min=(2 * min)-removedEle;
            return removedEle;
        }else{
            return stack.pop();
        }
    }

    public int getMin() {
        System.out.println("MIN: "+min);
        return min;
    }
}

//when inserted current < min = store 2xcurrent - min
//when pop current < min = set 2*min - current as min
 class testMinStack {
    public static void main(String args[]) {
        MinStack stack = new MinStack();

        stack.checkAndPush(10);
        stack.getMin();
        stack.checkAndPush(11);
        stack.getMin();
        stack.checkAndPush(9);
        stack.getMin();
        stack.checkAndPop();
        stack.getMin(); //O(1)
        stack.checkAndPop();
        stack.getMin();
        stack.checkAndPop();
        stack.getMin();
        stack.checkAndPop();
        stack.getMin();

        //confsion in top//normal top will return last elemtn. here it is diff but not much ise since goal is O(1) get Min only which is acheieved

    }


}
