package com.demo.spring.demo_spring.repositories;

import com.demo.spring.demo_spring.entities.Department;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Id> {
}
