package com.ragul.demo.problems;

import com.ragul.demo.LinkedList.SLLNode;
import com.ragul.demo.LinkedList.SinglyLinkedList;

public class IntersectionBetweenLL {
    public static void main(String args[]){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addData(3);
        list.addData(6);
        list.addData(9);
        list.addData(12);
   list.printAll();

        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.addData(1);
        list1.addData(9);
        list1.addData(2);
        list1.addData(7);
       list1.printAll();


        findIntersection(list.returnHead(),list1.returnHead()); //send head
    }

    private static void findIntersection(SLLNode head, SLLNode head1) {
        SLLNode current = head;
        while (current!=null){
          //  current.

        }

    }


}
