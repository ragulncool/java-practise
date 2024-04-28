package com.ragul.demo.Collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//when equals and hashcode not overriden, all field values are compared for equals and hashcode

//when hashcode is equals, equals is checked. Only when hashcode is same and equals is true, object is considered duplicate

//when hashcode is wrong, equals functionality is not disturbed
//when any of these is wrong, data structure behaviour like duplicate operations are disturbed
public class EmployeeApp {

    public static void main(String[] args){
        System.out.println("=======EQUALS========");
        Employee employee1 = new Employee(1,"A","coimbatore");
        Employee employee2 = new Employee(2,"B","chennai");
        Employee employee3 = new Employee(2,"B","chennai");
        Employee employee4 = new Employee(2,"B","chennai1");
        Employee employee5 = new Employee(3,"B","SF");
        System.out.println("ONE "+employee1.equals(employee2));
        System.out.println("TWO "+employee2.equals(employee3)); //always true even if equals and hashcode not overriden
        System.out.println("THREE "+employee3.equals(employee4));
        System.out.println("FOUR "+employee4.equals(employee5));

        System.out.println("=======SET========");
        Set<Employee> employeeSet = new HashSet<>(); //set rejects duplicates while map replaces duplicate keys
        employeeSet.add(employee1);
        employeeSet.add(employee2); //same as equals, default behvaioru
        employeeSet.add(employee3);
        employeeSet.add(employee4);
        employeeSet.add(employee5);
        System.out.println(employeeSet);

        System.out.println("=======MAP========");
        Map<Employee,String> employeeMap = new HashMap<>();
        employeeMap.put(employee1,"one");
        employeeMap.put(employee2,"two");
        employeeMap.put(employee3,"three");
        employeeMap.put(employee4,"four");
        employeeMap.put(employee5,"five");
        System.out.println(employeeMap);
    }
}
