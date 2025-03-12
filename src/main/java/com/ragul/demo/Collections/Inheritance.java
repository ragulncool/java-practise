package com.ragul.demo.Collections;

public class Inheritance {
    public static void main(String[] args) {
        Child c = new Child();
        c.method();

        Parent c1 = new Parent();
        c1.method();

        //UPCASTING
        Parent c2 = new Child(); //Can access  overriden methods of child class and all of parent class
        c2.method();
       // c2.method1(); Compile error since it is non overriden methid

//        Child c3 = new Parent(); //COmpile Error
//        c3.method();
    }

}

class Parent{

    void method(){
        System.out.println("Parent");
    }
}

class Child extends Parent{

    void method(){
        System.out.println("Child");
    }

    //not overriden method
    void method1(){
        System.out.println("non overriden child");
    }
}