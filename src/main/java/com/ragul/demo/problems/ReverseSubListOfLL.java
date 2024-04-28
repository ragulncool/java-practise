package com.ragul.demo.problems;

import com.ragul.demo.LinkedList.SLLDemo;
import com.ragul.demo.LinkedList.SLLNode;
import com.ragul.demo.LinkedList.SinglyLinkedList;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReverseSubListOfLL {

    public static void main(String args[]){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addData(10);
        list.addData(20);
        list.addData(30);
        list.addData(40);
        list.addData(50);
        list.addData(60);
        list.addData(70);
        list.addData(80);

       // list.printAll();

        //NOT WORKING
        list.reverseSubListOfLL(3,6);
        list.printAll();

        List<Integer> list1 = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Collections.reverse(list1.subList(0, 4)); //reverses only subList
       // System.out.println(list1);



    }
}
