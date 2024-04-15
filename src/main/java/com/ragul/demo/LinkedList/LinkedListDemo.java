package com.ragul.demo.LinkedList;

public class LinkedListDemo {
    LLNode head;

    public void addData(int data){
        LLNode lLNode = new LLNode(data);
        lLNode.setNext(this.head);
        this.head = lLNode;
    }

    public void printAll() {
        LLNode current = this.head;
        while(current!=null){
            System.out.print(" "+current.data);
            current=current.next;
        }

    }

    public int length() {
        LLNode current = this.head;
        int length=0;
        while(current != null){
            length=length+1;
            current=current.next;
        }
        return length;
    }

    public void deleteNthNode(int delPosition) {
        int position = length()-delPosition;
        LLNode current = this.head;
        int i=0;
        LLNode prev = null;
       while(current != null){
//           if(i==position-1){
//               prev=current;
//           }else if(i==position){
//               prev.next=current.next;
//               System.out.println("To be deleted "+current.data);
//           }
//simplified
           if(i==position-1){
               prev=current;
               System.out.println("Data to be deleted "+prev.next.data);
               prev.next=prev.next.next;
           }
           i++;
           current=current.next;
       }
    }
}
