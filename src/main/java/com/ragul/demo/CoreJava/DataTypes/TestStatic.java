package com.ragul.demo.CoreJava.DataTypes;

public class TestStatic {
    //STATIC LOADS FIRST. HENCE NON STTAIC WOULD NOT BE ACCESSED DIRECTLY FROM STATIC WITHOUT OBJECTS
    static int staticVar=1;

    int nonStaticVar=1;

    public static void main(String[] args) {

    }

    void nonStaticMethod(){
        nonStaticVar++;
        staticVar++;
        staticMethod();
    }

    static void staticMethod(){
        //nonStaticVar++; //COMPILE ERROR - Non-static field 'nonStaticVar' cannot be referenced from a static context
        TestStatic testStatic = new TestStatic(); //can be accessed by creating object in static
        testStatic.nonStaticVar++;


        staticVar++;
        //nonStaticMethod();//COMPILE ERROR - Non-static method 'nonStaticMethod()' cannot be referenced from a static context
        TestStatic testStatic1 = new TestStatic(); //can be accessed by creating object in static
        testStatic1.nonStaticMethod();
    }
}
