package com.demo.spring.demo_spring.services;

import com.demo.spring.demo_spring.dto.SellerDTO;
import com.demo.spring.demo_spring.entities.Department;
import com.demo.spring.demo_spring.entities.Seller;
import com.demo.spring.demo_spring.exceptions.DatabaseException;
import com.demo.spring.demo_spring.exceptions.ResourceNotFoundException;
import com.demo.spring.demo_spring.repositories.DepartmentRepository;
import com.demo.spring.demo_spring.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public List<SellerDTO> findAll() {
        List<Seller> result = repository.findAll();
        return result.stream().map(SellerDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public SellerDTO findById(Long id) {
        Seller entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Seller not found"));
        return new SellerDTO(entity);
    }

    @Transactional
    public SellerDTO insert(SellerDTO dto) {
            try {
                Seller entity = new Seller();
                entity.setName(dto.getName());
                entity.setEmail(dto.getEmail());
                entity.setBirthDate(dto.getBirthDate());
                entity.setBaseSalary(dto.getBaseSalary());

                Department dept = departmentRepository.findById(dto.getDepartment().getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

                entity.setDepartment(dept);
                entity = repository.save(entity);

                return new SellerDTO(entity);

            } catch (DataIntegrityViolationException e) {
                throw new DatabaseException("Email already exists");
            }
    }

    @Transactional
    public SellerDTO update(Long id, SellerDTO dto) {
        Seller entity = repository.getReferenceById(id);
        Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId());

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setBirthDate(dto.getBirthDate());
        entity.setBaseSalary(dto.getBaseSalary());
        entity.setDepartment(dept);

        entity = repository.save(entity);
        return new SellerDTO(entity);
    }

    @Transactional
    public void delete(Long id) {

        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException("ID dont exists");
        }
        try {
            repository.deleteById(id);
            repository.flush();

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

}
