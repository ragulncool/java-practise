package com.ragul.demo.Collections.Hashing;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

//if equals not overriden, does reference omaprision
//override and write custom logic to do comparion based on certain fields

//if equals() is true, hashcode() should always be same
//if hashcode() is same, equals() need not be true

@Getter
@Setter
public class Employee implements Comparable<Employee>{

    private int id;
    private String name;
    private String address;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return this.name.equals(employee.name);
//    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        boolean result = Objects.equals(this.name, employee.name);
        System.out.println("equals result : "+result);
        return result;
    }

    @Override
    public int hashCode() {
        int hashCode = Objects.hash(name);
        System.out.println("hashCode result : "+hashCode);
        return hashCode;

//        int hashcode = 0;
//                System.out.println("hashCode result : "+hashcode);
//        return hashcode;
    }

    public Employee(int id, String name, String address) {
        this.id=id;
        this.name=name;
        this.address=address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;
    }
}


//when equals and hashcode not overriden, all field values are compared for equals and hashcode

//when hashcode is equals, equals is checked. Only when hashcode is same and equals is true, object is considered duplicate

//when hashcode is wrong, equals functionality is not disturbed
//when any of these is wrong, data structure behaviour like duplicate operations are disturbed
class EmployeeEqualsAndHasCode {

    public static void main(String[] args){
        System.out.println("=======EQUALS========");
        Employee employee1 = new Employee(1,"A","coimbatore");
        Employee employee2 = new Employee(2,"B","chennai");
        Employee employee3 = new Employee(2,"B","chennai");
        Employee employee4 = new Employee(2,"B","chennai1");
        Employee employee5 = new Employee(3,"B","SF");
        System.out.println("ONE "+employee1.equals(employee2));
        System.out.println("TWO "+employee2.equals(employee3));
        System.out.println("THREE "+employee3.equals(employee4));
        System.out.println("FOUR "+employee4.equals(employee5));

        System.out.println("=======SET========"); //if hashcode is same, then only check for equal
        //if both true - data not added
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

class EmployeeCollectionoperations {

    public static void main(String[] args){
        System.out.println("=======EQUALS========");
        Employee employee1 = new Employee(1,"A","coimbatore");
        Employee employee2 = new Employee(2,"B","chennai");
        Employee employee3 = new Employee(2,"B","chennai");

        System.out.println("=======SET========");
        Set<Employee> employeeSet = new HashSet<>(); //set rejects duplicates while map replaces duplicate keys
        employeeSet.add(employee1);
        employeeSet.add(employee2); //same as equals, default behvaioru
        employeeSet.add(employee3);
        employeeSet.stream()
                .filter(employee -> employee.getAddress().startsWith("ch"))
                .forEach(employee -> System.out.println("LIST Filter: "+employee.getName()));

        System.out.println("=======MAP========");
        Map<Employee,String> employeeMap = new HashMap<>();
        employeeMap.put(employee1,"one");
        employeeMap.put(employee2,"two");
        employeeMap.put(employee3,"three");
        employeeMap.entrySet().stream()
                .filter(entry -> entry.getValue().startsWith("t"))
                .forEach(entry -> System.out.println("MAP Filter: "+entry.getKey().getName()));

        System.out.println("=======LIST OF POJO TO MAP========");
        Map<String,List<Employee>> employeeMap1 = new HashMap<>();
        employeeMap1 = employeeSet.stream().collect(Collectors.groupingBy(Employee::getName));


    }
}