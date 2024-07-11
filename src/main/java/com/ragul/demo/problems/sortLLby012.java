package com.ragul.demo.problems;

import com.ragul.demo.LinkedList.SLLNode;
import com.ragul.demo.LinkedList.SinglyLinkedList;

import java.util.LinkedList;

public class sortLLby012 {
    public static void main(String args[]){
        SinglyLinkedList list=new SinglyLinkedList();
        list.addData(1);
        list.addData(0);
        list.addData(1);
        list.addData(2);
        list.addData(0);
        list.addData(1);
        list.addData(2);
        list.addData(1);
        list.addData(1);

        sortLinkedList(list.returnHead());

    }

    private static void sortLinkedList(SLLNode head) {
        //count number of 0,1,2

        int[] count=new int[3];
        SLLNode current = head;
        while(current!=null){
            count[current.getData()]++;

            current=current.getNext();
        }
        System.out.println(count[0]+" "+count[1]+" "+count[2]);

        current=head;
        int i=0;
        while (current!=null){
           if(i<3 && count[i]>0){
               current.setData(i);
               count[i]=count[i]-1;
           }else if(i<3){
               i=i+1;
               current.setData(i);
               count[i]=count[i]-1;
           }

            System.out.println(current.getData());
            current=current.getNext();
       }
    }


}
