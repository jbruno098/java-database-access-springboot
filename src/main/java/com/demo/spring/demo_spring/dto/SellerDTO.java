package com.demo.spring.demo_spring.dto;

import com.demo.spring.demo_spring.entities.Seller;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class SellerDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    @PastOrPresent(message = "Birth date cannot be in the future")
    private LocalDate birthDate;

    @PositiveOrZero(message = "Salary cannot be negative")
    private Double baseSalary;

    private DepartmentDTO department;

    public SellerDTO() {
    }

    public SellerDTO(Long id, String name, String email, LocalDate birthDate, Double baseSalary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.baseSalary = baseSalary;
    }

    public SellerDTO(Seller entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        birthDate = entity.getBirthDate();
        baseSalary = entity.getBaseSalary();
        department = new DepartmentDTO(entity.getDepartment());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }
}
