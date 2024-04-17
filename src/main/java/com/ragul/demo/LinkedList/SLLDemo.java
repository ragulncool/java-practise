package com.ragul.demo.LinkedList;

//Delete Nth node from the end of the given Singly linked list
//
//Input: 2 -> 3 -> 1 -> 7 -> NULL, N = 2
//Output:
//The created linked list is:
//2 3 1 7
//The linked list after deletion is:
//2 3 7


public class SLLDemo {
    public static void main(String args[]){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addData(7);
        list.addData(1);
        list.addData(1);
        list.addData(1);
        list.addData(3);
        list.addData(2);
        list.addData(2);
        list.addData(8);
        list.addData(9);
        list.addData(9);
        list.printAll();
        int length = list.length();
        System.out.println("\nLength is "+length);

        System.out.println("====After Deletion in Nth position====");
        list.deleteNthNode(2);
        list.printAll();

        System.out.println("====After Deletion in mid position===="); //simialr to above
        list.deleteMiddleNode();
        list.printAll();

        System.out.println("====Reversing Linked List====");
        list.revereLinkedlist();
        list.printAll();

        System.out.println("====Search Element====");
        System.out.println(list.searchElement(8));
        System.out.println(list.searchElement(11));

        System.out.println("====Remove duplicates from sorted LL====");
        list.removeDuplicates();
        list.printAll();


        list.covertToCircular();
        System.out.println("====Is Circular? "+ list.checkCircular());
    }


}
