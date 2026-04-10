package com.demo.spring.demo_spring.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Department(){}

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Department setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }
}
