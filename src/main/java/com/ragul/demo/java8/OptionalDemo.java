package com.ragul.demo.java8;

import com.ragul.demo.Collections.Hashing.Employee;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        //NEED OF OPTIONAL
        // Optional is a container object which may or may not contain a non-null value.
        // It is used to avoid null checks and NullPointerExceptions in Java.

        Employee employee = null;

        String e=employee.getName();
        //System.out.println(e); //NullPointerException - if employee is null

        Optional<String> optName = Optional.ofNullable(employee.getName());
        System.out.println(optName); //No error is thrown

        //=====

        String s = "Demo";
        Optional<String> optStr = Optional.ofNullable(s);
        System.out.println(optStr.isEmpty()); //checks value == null
        System.out.println(optStr.isPresent()); //checks value != null
        System.out.println(optStr.get());
        String a = optStr.orElse("No value"); //if optStr is null, then "No value" is assigned

        String s1 = null;
        // Optional<String> optStr1 = Optional.of(s1); //If Nullable is not used, null cannot be assigned - Nullpointer
        Optional<String> optStr2 = Optional.ofNullable(s1); //or Optional.empty();
        System.out.println(optStr2.isEmpty());
        System.out.println(optStr2.isPresent());
        System.out.println(optStr2.get()); //NoSuchElementException: No value present
    }
}
