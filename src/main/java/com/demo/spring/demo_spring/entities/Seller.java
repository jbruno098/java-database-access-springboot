package com.demo.spring.demo_spring.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDate bitrhDate;
    private Double baseSalary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Seller(){}

    public Seller(Long id, String name, String email, LocalDate bitrhDate, Double baseSalary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bitrhDate = bitrhDate;
        this.baseSalary = baseSalary;
    }

    public Long getId() {
        return id;
    }

    public Seller setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Seller setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Seller setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getBitrhDate() {
        return bitrhDate;
    }

    public Seller setBitrhDate(LocalDate bitrhDate) {
        this.bitrhDate = bitrhDate;
        return this;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public Seller setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
