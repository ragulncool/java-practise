package com.ragul.demo.problems.DSA.DataStructures.LinkedList.SLL.Basics;

//singly LL
public class SLLNode {
    int data;
    SLLNode next;

    public SLLNode(int data) {
        this.data=data;
        next=null;
    }

    public void setNext(SLLNode node) {
        this.next=node;
    }

    public SLLNode getNext() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data=data;
    }
}
