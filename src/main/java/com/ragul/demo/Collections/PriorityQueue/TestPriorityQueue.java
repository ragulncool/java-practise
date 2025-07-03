package com.ragul.demo.Collections.PriorityQueue;


import java.util.Collections;
import java.util.PriorityQueue;

class TestPriorityQueue{

    public static void main(String args[]){
        //underdtsand diff b/w add and offer

        PriorityQueue<Integer> pq =new PriorityQueue<>();
        //stored in order according to priority
        System.out.println("Min-Heap elements in ascending order:");
        pq.add(15);
        pq.add(10);
        pq.add(25);
        pq.offer(12);


        //pq.add(null);  -ERROR  -PQ doesnt allow any non comparable values
        System.out.println(pq.contains(10));
        System.out.println(pq);

        System.out.println(pq.peek());//returns lowest priorty element
        pq.poll(); //
        System.out.println(pq);
        System.out.println(pq.peek());
        pq.clear();

        // Create a Max-Heap using Collections.reverseOrder()
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);
        maxHeap.add(2);
        System.out.println("Max-Heap elements in descending order:");
        System.out.println(maxHeap);

       // PriorityQueue<Integer> h1 = new PriorityQueue<>(new );

    }


}
