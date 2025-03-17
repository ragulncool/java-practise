package com.ragul.demo.springboot.files.Hibernate;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.List;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL) //mappedBy @ManyToOne field in other class - to avoid creating extra table by class italed
    private List<Address> address;

    // Constructors, getters, and setters
}