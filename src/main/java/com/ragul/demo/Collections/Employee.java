package com.ragul.demo.Collections;

import lombok.Data;

import java.util.Objects;

@Data
public class Employee {

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
        int hashCode = Objects.hash(id, name);
        System.out.println("hashCode result : "+hashCode);
        return hashCode;
    }

    public Employee(int id, String name, String address) {
        id=this.id;
        name=this.name;
        address=this.address;
    }


}
