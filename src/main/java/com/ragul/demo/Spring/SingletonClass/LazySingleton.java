package com.ragul.demo.Spring.SingletonClass;

//In the context of the singleton pattern,
// lazy initialization restricts the creation of the instance until it is requested for the first time.
public class LazySingleton {

    private static volatile LazySingleton instance = null;

    // private constructor
    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
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