package com.ragul.demo.CoreJava.DataTypes;

    class A {
        static {
            System.out.println("Static initializer of A");
        }
        {
            System.out.println("Instance initializer of A");
        }
        A() {
            System.out.println("Constructor of A");
        }
    }

    class B extends A {
        static {
            System.out.println("Static initializer of B");
        }
        {
            System.out.println("Instance initializer of B");
        }
        B() {
            System.out.println("Constructor of B");
        }
    }

    public class StaticDemo {
        public static void main(String[] args) {
            new B();
        }
}
