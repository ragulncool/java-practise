package com.ragul.demo.Spring.SingletonClass;

//In an eager initialization singleton pattern, the singleton instance is created
// irrespective of whether any other class actually asked for its instance or not.
public class EagerSingleton {

    private static volatile EagerSingleton instance = new EagerSingleton();
//use of static is to ensure that the instance is created at the time of class loading,
    // which means the instance is created even before any thread accesses it.
    // This is useful in scenarios where the singleton instance is required immediately
    // after the class is loaded, and it avoids the overhead of lazy initialization.
    // The volatile keyword ensures that the instance variable is read from and written to main memory,

    //private constructor to prevent instantiation
    //A private constructor in Java restricts the instantiation of a class from outside its own definition. This means that objects of a class with a private constructor cannot be created directly using the new keyword from other classes.
    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}

class CheckSingleton{

    public static void main(String[] args) {
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();

        // Both instances should be the same
        System.out.println("Are both instances equal? " + (instance1 == instance2));

        //comment private constructor and try below else compile error
        //'EagerSingleton()' has private access in 'com.ragul.demo.Spring.SingletonClass.EagerSingleton'
//        EagerSingleton instance3 = new EagerSingleton(); // This will cause a compile error
//        EagerSingleton instance4 = new EagerSingleton();
//        System.out.println("Are both instances equal? " + (instance3 == instance4));

    }
}