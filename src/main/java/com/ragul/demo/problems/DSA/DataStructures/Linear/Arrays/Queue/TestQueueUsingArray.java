package com.ragul.demo.problems.DSA.DataStructures.Linear.Arrays.Queue;

public class TestQueueUsingArray {
    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl(10);
        queue.enqueue(2);
        queue.enqueue(5);
        queue.enqueue(1);
        queue.enqueue(10);
        queue.enqueue(7);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }
}

class QueueImpl{
    int front;
    int rear;
    int[] arr;

    QueueImpl(int maxCapacity){
        front=-1;
        rear=-1;
        arr= new int[maxCapacity];
    }


    public void enqueue(int num) {
        if(rear==arr.length-1){
            System.out.println("Queue Overflow");
            return;
        }

        //first element
        if(front==-1){
            front=0;
        }

        rear++;
        arr[rear] = num;
    }

    public void dequeue() {
        if(front==-1 || front>rear){
            System.out.println("Queue Underflow");
            return;
        }

        front++;

        // if queue becomes empty
        if(front>rear){
            front=-1;
            rear=-1;
        }
    }

    public  String toString(){
        if (front == -1) {
            return "Queue is empty";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=front; i<=rear;i++){
            stringBuilder.append(arr[i]+" ");
        }
        return String.valueOf(stringBuilder);
    }
}
