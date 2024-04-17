package com.ragul.demo.LinkedList;

public class SinglyLinkedList {
    //LL has only head info for traversing. Important to set it at the end of all operations
    SLLNode head;

    public void addData(int data){
        SLLNode lLNode = new SLLNode(data);
        lLNode.setNext(this.head);
        this.head = lLNode;
    }

    public void printAll() {
        SLLNode current = this.head;
        while(current!=null){
            System.out.println(" "+current.data);
            current=current.next;
        }

    }

    public int length() {
        SLLNode current = this.head;
        int length=0;
        while(current != null){
            length=length+1;
            current=current.next;
        }
        return length;
    }

    public void deleteNthNode(int delPosition) {
        int position = length()-delPosition+1; //from head
        SLLNode current = this.head;
        int i=0;
        SLLNode prev = null;
       while(current != null){
//           if(i==position-1){
//               prev=current;
//           }else if(i==position){
//               prev.next=current.next;
//               System.out.println("To be deleted "+current.data);
//           }
//simplified
           if(i==position){
               prev=current;
               System.out.println("Data to be deleted "+prev.next.data);
               prev.next=prev.next.next;
           }
           i++;
           current=current.next;
       }

    }

    public void deleteMiddleNode() {
        int middlePosition = (length()/2)+1;
        System.out.println("Middle Position from last to be deleted "+middlePosition);
        deleteNthNode(middlePosition);
    }

    public void revereLinkedlist() {
        SLLNode current = head;
        SLLNode prev = null;
        SLLNode next = null;
        while(current!=null){

            //change pointers
            next = current.next;
            current.next=prev;

            //swap prev and current
            prev = current;
            current=next;
        }
        head=prev; //Linked list knows only head
    }

    public void rotate(int data) {
        SLLNode current = head;

        current.next=head;


    }

    public boolean checkCircular() {

        // An empty linked list is circular
        if (head == null)
            return true;

        SLLNode current = head.next; //start from next node of 2nd

        // Loop will terminate in 2 cases
        // 1. Non Circular List - current==null
        // 2. Circular List - current==head
        while(current!=null && current!=head){
          current=current.next;
        }
        return current==head;
    }

    public void covertToCircular() {
        SLLNode current = head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=head;
    }

    public boolean searchElement(int searchData) {
        SLLNode current = head;
        while (current.next!=null){
            if(current.data==searchData){
                return true;
            }
            current=current.next;
        }
        return false;
    }

    public void removeDuplicates() {
        SLLNode current = head;
        while (current!=null){
            if(current.next!=null && current.data==current.next.data){
                current.next=current.next.next; //remove 2nd duplicate from link
            }
            current=current.next; //subsequently check further notes and will be removed if any duplicates
        }
    }
}
