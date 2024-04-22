package com.ragul.demo.LinkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCacheImpl {
    //DLL has only head info and tail info for traversing. Important to set it at the end of all operations
    LRUNode head;
    LRUNode tail;
    int capacity;
    List<LRUNode> list = new LinkedList<>();
    Map<Integer, LRUNode> map = new HashMap<>();
    int count;

    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
        count=0;
        head=null;
        tail=null;
    }

    public int getCache(int key) {
        LRUNode node= map.get(key);
        if(node==null) {
            return -1;
        }else{
            deleteNode(node);
            addNodeToHead(node);
            return node.data;
        }
    }

    public void putToCacheFront(int key, int data){
       LRUNode existingKey= map.get(key);

        if(existingKey==null){
            LRUNode newNode = new LRUNode(key, data);
            map.put(key, newNode);
            if(count<capacity){
                addNodeToHead(newNode);
            }else{
                deleteNode(tail);
                addNodeToHead(newNode);
            }
        }else{
            LRUNode node = map.get(key); //key already exist
            deleteNode(node);
            node.data = data;
            addNodeToHead(node);
        }
    }

    private void addNodeToHead(LRUNode node){
        LRUNode next = null;
        if(head==null){ //for single node , head and tail are same
            tail=node;
        }else{
            head.prev=node;
        }
        node.next=head;
        node.prev=null;
        head=node;
        count++;
    }

    private void deleteNode(LRUNode node){
        if(tail==null){
            //scenario will not happen
        }
        LRUNode prev = node.prev;
        LRUNode next = node.next;
        prev.next=next;
        if(next!=null){ //not last node
            next.prev=prev;
        }else{ //last node
            tail=prev;
        }
        map.remove(node.key);
        count--;
    }


    public void printAll() {
        LRUNode current = this.head;
        while (current != null) {
            System.out.println(" " + current.data);
            current = current.next;
        }
    }
}
