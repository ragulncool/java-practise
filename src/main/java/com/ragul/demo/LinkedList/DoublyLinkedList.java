package com.ragul.demo.LinkedList;

public class DoublyLinkedList {
    DLLNode head;
    DLLNode tail;

    public void insertAtHead(int data) {
        DLLNode node = new DLLNode(data);
        node.next=head;
        if(head!=null){ //if this is not first insertion
            head.prev=node;
        }

        head=node;
        if(tail==null){ //if this is the first element, tail and head will be same
            tail=node;
        }
    }

    public void insertAtTail(int data) {
        DLLNode node = new DLLNode(data);
        node.prev=tail;
        if(tail!=null){ //if this is not first insertion
            tail.next=node;
        }

        tail=node;
        if(head==null){ //if this is the first element, tail and head will be same
            head=node;
        }
    }

    public void printFromHead() {
        DLLNode current=head;
        while(current!=null){
            System.out.println(current.data);

            current=current.next;
        }
    }

    public void printFromTail() {
        DLLNode current=tail;
        while(current!=null){
            System.out.println(current.data);

            current=current.prev;
        }
    }

    public void reverseDLL() {
        DLLNode current = head;
        DLLNode prev = null;
        DLLNode next = null;
        while(current!=null){
            next=current.next;
            prev=current.prev;
            current.prev=next;
            current.next=prev;

            current=next;
        }
        if (prev != null) {
            head=prev;
        }
        System.out.println(head.data);
    }


//    public boolean detectLoop() {
//        DLLNode current = head;
//        while (current!=null){
//            if()
//
//                current=current.
//        }
//
//    }
}


