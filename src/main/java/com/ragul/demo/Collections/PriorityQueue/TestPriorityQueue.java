package com.ragul.demo.Collections.PriorityQueue;


import java.util.PriorityQueue;

class TestPriorityQueue{

    public static void main(String args[]){
        //underdtsand diff b/w add and offer

        PriorityQueue<Integer> pq =new PriorityQueue<>();
        //stored in order according to priority, high -> low(left to right)
        //lowest value will have highest priority
        pq.add(15);
        pq.add(10);
        pq.add(25);
        pq.offer(12);


        //pq.add(null);  -ERROR  -PQ doesnt allow any non comparable values
        System.out.println(pq.contains(10));
        System.out.println(pq);

        System.out.println(pq.peek());//returns highest priorty element
        pq.poll(); //removes highest priority element
        System.out.println(pq);
        System.out.println(pq.peek());
        pq.clear();
    }


}
