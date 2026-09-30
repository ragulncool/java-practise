package com.ragul.demo.problems.tier1;

import com.ragul.demo.Collections.Hashing.Employee;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondHighestSalary {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "John", "New York", new BigDecimal("50000"),"operations"));
        employeeList.add(new Employee(2, "Jane", "Los Angeles", new BigDecimal("60000"),"scm"));
        employeeList.add(new Employee(3, "Mike", "Chicago", new BigDecimal("70000"),"hr"));
        employeeList.add(new Employee(4, "Emily", "Houston  ", new BigDecimal("80000"),"hr"));


        BigDecimal salary = employeeList.stream()
                .map(Employee::getSalary)
                .distinct() // to avoid duplicates in case multiple employees have the same salary
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()//return type Optional
                .orElse(null);

        System.out.println(salary);

        //list to map or group by department

        //all employees
        Map<String,  List<Employee>> e = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
       //all employee count
         employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        //avg salary
//        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Employee::getSalary)));

        System.out.println(e);

    }
}
