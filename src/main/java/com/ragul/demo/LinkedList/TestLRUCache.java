package com.ragul.demo.LinkedList;

public class TestLRUCache {
    public static void main(String args[]){
        LRUCacheImpl list = new LRUCacheImpl(4);
        list.putToCacheFront(5,5);
        System.out.println("===Data (head to tail)==");
        list.printAll();
        list.putToCacheFront(1,1);
        System.out.println("===Data (head to tail)==");
        list.printAll();
        list.putToCacheFront(2,2);
        System.out.println("===Data (head to tail)==");
        list.printAll();
        list.putToCacheFront(3,3);
        System.out.println("===Data (head to tail)==");
        list.printAll();
        list.putToCacheFront(10,10);
        System.out.println("===Data (head to tail)==");
        list.printAll();

        System.out.println("===After get 2==");
        System.out.println("position :"+list.getCache(2));
        list.printAll();

        System.out.println("===After get 22==");
        System.out.println("position :"+list.getCache(22));
        list.printAll();

        System.out.println("===After get 3==");
        System.out.println("position :"+list.getCache(3));
        list.printAll();
    }

}
