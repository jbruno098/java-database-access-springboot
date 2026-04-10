package com.demo.spring.demo_spring.controllers;

import com.demo.spring.demo_spring.entities.Department;
import com.demo.spring.demo_spring.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Department> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Department insert(@RequestBody Department dep) {
        return service.insert(dep);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id,@RequestBody Department dep) {
        return service.update(id,dep);
    }

}
