package com.ragul.demo.LinkedList;

import java.util.HashSet;

public class DoublyLinkedList {
    DLLNode head;
    DLLNode tail;
    HashSet<DLLNode> st;

    DoublyLinkedList(){
        st = new HashSet<>();
    }


    public void insertAtHead(int data) {
        DLLNode node = new DLLNode(data);

        //for easy search for any operations
        st.add(node);

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

        //for easy search for any operations
        st.add(node);

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
        DLLNode prev =null;
        DLLNode next ;
        while(current!=null){
            next=current.next;
            prev=current.prev; //null for head
            current.prev=next;
            current.next=prev;

            current=next;
        }
        if (prev != null) {
            head=prev.next;
        }
    }


    public boolean detectLoop() {
        boolean isCycleDetected = false;
        DLLNode current = head;
        while (current!=null){
            DLLNode next = current.next;
            while (next!=null){
                if(current.data==next.data){ //simulated by data. but actually node should be same //current == next instead of comparing data alone
                    System.out.println(current.data+" is repeated");
                    isCycleDetected = true;
                    return isCycleDetected;
                }
                next = next.next;
            }
            current = current.next;
        }
        return isCycleDetected;
    }

     boolean detectLoopUsingHashMap() {

        while (head != null) {

            // If this node is already present
            // in hashmap it means there is a cycle
            if (st.contains(head))
                return true;

            // If we are seeing the node for
            // the first time, insert it in hash
            st.add(head);
            head = head.next;
        }
        return false;
    }
}


