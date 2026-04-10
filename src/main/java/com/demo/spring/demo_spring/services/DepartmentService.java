package com.demo.spring.demo_spring.services;

import com.demo.spring.demo_spring.entities.Department;
import com.demo.spring.demo_spring.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    public List<Department> findAll() {
        return repository.findAll();
    }
}
