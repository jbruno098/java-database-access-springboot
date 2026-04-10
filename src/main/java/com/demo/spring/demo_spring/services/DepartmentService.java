package com.demo.spring.demo_spring.services;

import com.demo.spring.demo_spring.entities.Department;
import com.demo.spring.demo_spring.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public List<Department> findAll() {
        return repository.findAll();
    }

    public void insert(Department dep) {
        repository.save(dep);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
