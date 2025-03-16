package com.ragul.demo.springboot.files.Hibernate;

import com.ragul.demo.springboot.files.Hibernate.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    private String id;

    @OneToOne
    @MapsId
    private Person person;

    private String city;

    // Constructors, getters, and setters
}