package com.ragul.demo.java8;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo { //-> SHORTHAND FOR LAMDA

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);

        //4 TYPES OF METHOD REFERENCE

        //1. Static Method Reference -> Reference to a Static Method
        list.forEach(x->System.out.println(x)); //using lamda
        list.forEach(System.out::println); //dont put method braces()


    }
}
