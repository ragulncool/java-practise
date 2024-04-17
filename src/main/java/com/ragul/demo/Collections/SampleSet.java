package com.ragul.demo.Collections;

import java.util.*;

public class SampleSet {
    public static void main(String args[]){


//No toSet from array, sublist, lastindexof, get
        Set<String> set1=new HashSet<>();
        Set<String> set2=new HashSet<>();

        set2.addAll(set1);
        set1.add("sample");
        set1.size();
        System.out.println(set2.containsAll(set1));
        System.out.println(set2.contains("A"));
        set2.clear();
    }
}
