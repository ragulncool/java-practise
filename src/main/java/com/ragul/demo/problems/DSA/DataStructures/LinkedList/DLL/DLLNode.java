package com.ragul.demo.problems.DSA.DataStructures.LinkedList.DLL;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DLLNode {
    int data;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int data){
        this.data=data;
        prev=null;
        next=null;
    }
}
