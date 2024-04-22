package com.ragul.demo.LinkedList;

public class LRUNode {
    int key; //new
    int data;
    LRUNode prev;
    LRUNode next;

    LRUNode(int key, int data){
        this.key=key;
        this.data=data;
        prev=null;
        next=null;
    }
}
