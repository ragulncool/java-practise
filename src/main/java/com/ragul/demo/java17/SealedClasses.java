package com.ragul.demo.java17;
//Sealed classes allow you to restrict which classes or interfaces can extend or implement them.
public class SealedClasses {
    public sealed class Shape permits Circle, Square {
        // Common properties and methods for all shapes
    }

    final class Circle extends Shape {
        // Circle-specific properties and methods
    }

    final class Square extends Shape {
        // Square-specific properties and methods
    }

    //ERROR - 'Triangle' is not allowed in the sealed hierarchy
//    final class Triangle extends Shape {
//        // Triangle-specific properties and methods
//    }

}
