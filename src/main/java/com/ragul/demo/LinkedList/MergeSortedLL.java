package com.ragul.demo.LinkedList;

public class MergeSortedLL {
    public static void main(String[] args) {
        SinglyLinkedList sll_1 = new SinglyLinkedList();
        sll_1.addData(9);
        sll_1.addData(7);
        sll_1.addData(5);
        sll_1.addData(3);
        sll_1.addData(1);

        SinglyLinkedList sll_2 = new SinglyLinkedList();
        sll_2.addData(6);
        sll_2.addData(5);
        sll_2.addData(4);
        sll_2.addData(2);

        SinglyLinkedList sll_3 = mergeSortedLL(sll_1,sll_2);
        sll_3.printAll();
    }

    //understood working. LL implementation is wrong
    private static SinglyLinkedList mergeSortedLL(SinglyLinkedList sll_1, SinglyLinkedList sll_2) {
        SinglyLinkedList sll_3 = new SinglyLinkedList();
        SLLNode firstCurrent = sll_1.head;
        SLLNode secondCurrent = sll_2.head;
        while (firstCurrent!=null && firstCurrent.next!=null && secondCurrent!=null && secondCurrent.next!=null){
            if(firstCurrent.data<secondCurrent.data){
                sll_3.addData(firstCurrent.data);
                firstCurrent = firstCurrent.next;
            }else{
                sll_3.addData(secondCurrent.data);
                secondCurrent = secondCurrent.next;
            }
        }

        //add remaining elements in both
        while (firstCurrent!=null){
            sll_3.addData(firstCurrent.data);
            firstCurrent = firstCurrent.next;
        }

        while (secondCurrent!=null){
            sll_3.addData(secondCurrent.data);
            secondCurrent = secondCurrent.next;
        }
        return sll_3;
    }
}
