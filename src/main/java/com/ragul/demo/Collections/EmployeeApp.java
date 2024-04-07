package com.ragul.demo.Collections;

public class EmployeeApp {

    public static void main(String[] args){
        Employee employee1 = new Employee(1,"A","coimbatore");
        Employee employee2 = new Employee(2,"B","chennai");

        System.out.println(employee1.equals(employee2));
    }
}
