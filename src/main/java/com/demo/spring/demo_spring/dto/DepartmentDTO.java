package com.demo.spring.demo_spring.dto;

import com.demo.spring.demo_spring.entities.Department;
import jakarta.validation.constraints.NotBlank;

public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDTO(Department entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
