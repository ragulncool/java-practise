package com.ragul.demo.java8;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
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
