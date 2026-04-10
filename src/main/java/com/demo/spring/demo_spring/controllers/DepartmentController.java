package com.demo.spring.demo_spring.controllers;

import com.demo.spring.demo_spring.entities.Department;
import com.demo.spring.demo_spring.repositories.DepartmentRepository;
import com.demo.spring.demo_spring.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    public Department findById(Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Department> findAll() {
        return service.findAll();
    }

}
