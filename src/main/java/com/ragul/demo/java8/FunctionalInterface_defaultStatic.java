package com.ragul.demo.java8;

//@FunctionalInterface - if annotatioon is used and more than 1 abstract method - will throw error
public interface FunctionalInterface_defaultStatic {
    //Default methods allow you to add new methods to interfaces without forcing all implementing classes to provide an implementation.
    //backwards compatible
    default void defaultMethod(){
        System.out.println("parent default method");
    }

    //Static methods in interfaces are similar to static methods in classes.
    // They can be called without an instance of the interface.
    static void staticMethod(){
        System.out.println("static method");
    }

    //void methodOne();

//    default vs static
//    default methods can be overridden in implementing classes, while static methods cannot be overridden and are called using the interface name.

}

class ChildFunctionalInterface implements FunctionalInterface_defaultStatic {

    @Override
    public void defaultMethod() {
        System.out.println("overridden default method");
    }

}

class UnderstandFuncInterface{

    public static void main(String[] args) {
        FunctionalInterface_defaultStatic functionalInterface = new FunctionalInterface_defaultStatic() {};
       functionalInterface.defaultMethod();
        FunctionalInterface_defaultStatic.staticMethod();
    }
}

//default method is introduces to have stream methods
//eg: stream method added in COllection interfcae
//eg: sort method added in list interface (extends collection interface)