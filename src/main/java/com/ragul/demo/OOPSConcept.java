package com.ragul.demo;

public class OOPSConcept{ //extends Dummy// 2.Inheritance

    private int value;

    public int getValue() { //1. class encapsulates data name and method (behaviour) getName
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public void incrementValue(){ //3. Even without a parent or child class, A can abstract away internal details.
// By providing methods that perform meaningful actions without exposing internal logic, the class demonstrates abstraction.
        value++;
    }

    public void incrementValue(int incrementer){ //4. polymorphism       value=value+incrementer;
    }
}
