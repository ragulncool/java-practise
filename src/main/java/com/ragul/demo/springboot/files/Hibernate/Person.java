package com.ragul.demo.springboot.files.Hibernate;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Address address;

    // Constructors, getters, and setters
}