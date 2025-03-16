package com.ragul.demo.java8;

//@FunctionalInterface - if annotatioon is used and more than 1 abstract method - will throw error
public interface FunctionalInterfaceDemo {
    default void defaultMethod(){
        System.out.println("default method");
    }

    static void staticMethod(){
        System.out.println("static method");
    }

    //void methodOne();

}

class UnderstandFuncInterface{

    public static void main(String[] args) {
        FunctionalInterfaceDemo functionalInterface = new FunctionalInterfaceDemo() {};
       functionalInterface.defaultMethod();
        FunctionalInterfaceDemo.staticMethod();
    }
}

//default method is introduces to have stream methods
//eg: stream method added in COllection interfcae
//eg: sort method added in list interface (extends collection interface)