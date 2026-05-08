package com.demo.spring.demo_spring.services;

import com.demo.spring.demo_spring.dto.DepartmentDTO;
import com.demo.spring.demo_spring.entities.Department;
import com.demo.spring.demo_spring.exceptions.DatabaseException;
import com.demo.spring.demo_spring.exceptions.ResourceNotFoundException;
import com.demo.spring.demo_spring.repositories.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        return new DepartmentDTO(department);
    }

    @Transactional(readOnly = true)
    public List<DepartmentDTO> findAll() {
        List<Department> result = repository.findAll();
        return result.stream().map(DepartmentDTO::new).toList();
    }

    @Transactional
    public DepartmentDTO insert(DepartmentDTO dto) {

        try {
            Department dept = new Department();
            dept.setName(dto.getName());
            dept = repository.save(dept);
            return new DepartmentDTO(dept);

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Department name already exists");
        }
    }

    @Transactional
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ID dont exists");
        }
        try {
            repository.deleteById(id);
            repository.flush();

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    @Transactional
    public DepartmentDTO update(Long id, DepartmentDTO dto) {

        try {
            Department entity = repository.getReferenceById(id);
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new DepartmentDTO(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("ID dont exists");
        }
    }
}
