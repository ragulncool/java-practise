package com.ragul.demo.snippets;

public class InheritanceProblem2 {
    public static void main(String[] args) {
        D d = new D();
        d.i = 10;
        C.j = 20;
        d.k = 30;
        d.display();
    }
}

class C {
  int i;
  static int j;
}

class D extends C {
    int k;
    void display() {
        System.out.println(i + " " + j+" "+k);
    } //proves static members are inherited to subclass like others members
}

