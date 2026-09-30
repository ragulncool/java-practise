package com.ragul.demo.java17;

public class TestStudentRecord {
    public static void main(String[] args) {
        StudentRecord student1 = new StudentRecord(1, "Ragul");


//        StudentRecord student1 = new StudentRecord(1, "Ragul");

//        student1.id()=10; // This line will cause a compile-time error since records are immutable
//        StudentRecord student2 = new StudentRecord(2);

        System.out.println("Student 1 ID: " + student1.id() + ", Name: " + student1.name());
    }
}
