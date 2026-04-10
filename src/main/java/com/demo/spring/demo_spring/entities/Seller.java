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
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "base_salary")
    private Double baseSalary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Seller(){}

    public Seller(Long id, String name, String email, LocalDate birthDate, Double baseSalary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Seller setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Seller setBitrhDate(LocalDate bitrhDate) {
        this.birthDate = birthDate;
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
