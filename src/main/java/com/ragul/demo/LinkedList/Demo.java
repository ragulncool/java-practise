package com.ragul.demo.LinkedList;

//Delete Nth node from the end of the given Singly linked list
//
//Input: 2 -> 3 -> 1 -> 7 -> NULL, N = 2
//Output:
//The created linked list is:
//2 3 1 7
//The linked list after deletion is:
//2 3 7


public class Demo {
    public static void main(String args[]){
        LinkedListDemo list = new LinkedListDemo();
        list.addData(7);
        list.addData(1);
        list.addData(3);
        list.addData(2);
        list.printAll();
        int length = list.length();
        System.out.println("\nLength is "+length);

        list.deleteNthNode(2);
        list.printAll();
    }


}
