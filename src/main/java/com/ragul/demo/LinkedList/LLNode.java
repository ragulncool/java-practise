package com.ragul.demo.LinkedList;

//singly LL
public class LLNode {
    int data;
    LLNode next;

    public LLNode(int data) {
        this.data=data;
        next=null;
    }

    public void setNext(LLNode node) {
        this.next=node;
    }
}
