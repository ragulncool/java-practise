package com.ragul.demo.springboot.files.Hibernate;

import com.ragul.demo.springboot.files.Hibernate.Person;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    private String id;

    @ManyToOne
    private Person person;

    private String city;

    // Constructors, getters, and setters
}