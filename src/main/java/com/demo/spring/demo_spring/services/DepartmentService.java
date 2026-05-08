package com.demo.spring.demo_spring.services;

import com.demo.spring.demo_spring.dto.DepartmentDTO;
import com.demo.spring.demo_spring.entities.Department;
import com.demo.spring.demo_spring.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Transactional(readOnly = true)
    public DepartmentDTO findById(Long id) {
        Department department = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return new DepartmentDTO(department);
    }

    @Transactional(readOnly = true)
    public List<DepartmentDTO> findAll() {
        List<Department> result = repository.findAll();
        return result.stream().map(DepartmentDTO::new).toList();
    }

    @Transactional
    public DepartmentDTO insert(DepartmentDTO dto) {
        Department dept = new Department();
        dept.setName(dto.getName());
        dept = repository.save(dept);
        return new DepartmentDTO(dept);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public DepartmentDTO update(Long id, DepartmentDTO dto) {
        Department entity = repository.getReferenceById(id);
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new DepartmentDTO(entity);
    }
}
