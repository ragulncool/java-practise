package com.ragul.demo.Spring.SingletonClass;

//In the context of the singleton pattern,
// lazy initialization restricts the creation of the instance until it is requested for the first time.

//Singleton class is not thread-safe by default.
// To make it thread-safe, we can use synchronized blocks or other concurrency control mechanisms.
public class LazySingleton {

    private static volatile LazySingleton instance = null;

    // private constructor
    private LazySingleton() {
    }

    //Double-Checked Locking -
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                // Double check
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}