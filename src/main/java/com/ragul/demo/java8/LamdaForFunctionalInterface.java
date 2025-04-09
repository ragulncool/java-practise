package com.ragul.demo.java8;

//not clear
public interface LamdaForFunctionalInterface {
    Integer add(Integer a, Integer b);
}

//OLD
class FuncClass implements LamdaForFunctionalInterface{
    @Override
    public Integer add(Integer a, Integer b) {
        return a+b;
    }
}

class CustomFuncIntDemo{
    public static void main(String[] args) {
        //COMPILE ERROR - will ask to implement interface
     //   LamdaForFunctionalInterface functionalInterface = new LamdaForFunctionalInterface();

        //OLD
        LamdaForFunctionalInterface functionalInterface = new FuncClass();
        System.out.println(functionalInterface.add(10,20));



        //Lamda Type 1 - Anonymous class
        LamdaForFunctionalInterface functionalInterface_lamda2 = new LamdaForFunctionalInterface(){
            @Override
            public Integer add(Integer a, Integer b) {
                return a+b;
            }
        };
        System.out.println(functionalInterface_lamda2.add(10,20));

        //Lamda Type 2 - rewrite the above code in lamda
        LamdaForFunctionalInterface functionalInterface_lamda = (a,b) -> a+b;
        System.out.println(functionalInterface_lamda.add(10,20));

    }
}

// An anonymous inner class can be useful when making an instance of an object with certain "extras"
// such as overloading methods of a class or interface, without having to actually subclass a class.
//
// In simple words, a class that has no name is known as an anonymous inner class in Java.
// It should be used if you have to override a method of class or interface.
// Java Anonymous inner class can be created in two ways:
//
// Class (may be abstract or concrete).
// Interface