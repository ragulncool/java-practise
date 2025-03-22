package com.ragul.demo.Multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class CollectionsForMultithreading {
    //unsynchronized - not threadsafe
    //synchronized - threadsafe

    public static void main(String args[]){
        // Non synchronized
        List l1 = new ArrayList();
        // Synchronized
        List l= Collections.synchronizedList(l1);


        //synchronized by default
        Vector<Integer> v=new Vector<>();
    }
}
