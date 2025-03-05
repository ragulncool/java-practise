package com.ragul.demo.Spring.SingletonClass;

//In an eager initialization singleton pattern, the singleton instance is created
// irrespective of whether any other class actually asked for its instance or not.
public class EagerSingleton {

    private static volatile EagerSingleton instance = new EagerSingleton();

    // private constructor
    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}