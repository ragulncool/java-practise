package com.ragul.demo.LinkedList;

public class DLLDemo {
    public static void main(String args[]){
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println("After Insertion in Head:");
        list.insertAtHead(3);
        list.insertAtHead(1);
        list.insertAtHead(2);
        System.out.println("Print from Head:");
        list.printFromHead();

        System.out.println("After Insertion in Tail:");
        list.insertAtTail(9);
        list.insertAtTail(8);
        System.out.println("Print from Head:");
        list.printFromHead();
        System.out.println("Print from Tail:");
        list.printFromTail();
//        System.out.println("After Reversing DLL:");
//        list.reverseDLL(); //NOT WORKING



    }
}
