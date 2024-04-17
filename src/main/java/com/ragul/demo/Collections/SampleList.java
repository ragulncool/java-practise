package com.ragul.demo.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleList {
    public static void main(String args[]){

        //ARRAY TO list
        String a[]= new String[] { "sample", "A", "B", "C", "D" };
        List<String> list = Arrays.asList(a);

        List<String> list1=new ArrayList<>();
        list1.addAll(list);
    //   list.add("sample"); ERROR CANNOT ADD
        list1.add("sample");
        list1.get(0);
        list.size();
        list1.addAll(list);
        System.out.println(list1.containsAll(list));
        System.out.println(list.contains("A"));
        System.out.println(list.subList(1,2)); //start index, endindex-1
        System.out.println(list1);
        //returns index of last occurence of the object
        System.out.println(list1.lastIndexOf("sample")); //-1 if not exist

       // list.clear(); ERROR CANNOR CLEAR
        list1.clear();
    }
}
