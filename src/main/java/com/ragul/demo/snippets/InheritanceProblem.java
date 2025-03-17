package com.ragul.demo.snippets;

public class InheritanceProblem {
    public static void main(String[] args) {
        B b = new B();
        b.i = 10;
        b.j = 20;
        b.display();
    }
}

class A {
  int i;
}

class B extends A {
    int j;
    void display() {
        System.out.println(i + " " + j);
    }
}

