package com.ragul.demo.java8.SomeFuncInterfaces;

public class CustomFunctionalInterface {
    // A functional interface is an interface that contains exactly one abstract method.
    // It can have multiple default or static methods.
    @FunctionalInterface
    public interface MyFunctionalInterface {
        int add(int a, int b); // Abstract method
    }

    public static void main(String[] args) {
        // Using the functional interface with a lambda expression for implementation
        MyFunctionalInterface myFunc = (a, b) -> {
            return a + b; // Implementation of the single abstract method
        };

        // Calling the method defined in the functional interface
        System.out.println( myFunc.add(5, 10));
    }

}
