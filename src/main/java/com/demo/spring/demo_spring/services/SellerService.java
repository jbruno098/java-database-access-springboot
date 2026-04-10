package com.demo.spring.demo_spring.services;

import com.demo.spring.demo_spring.entities.Department;
import com.demo.spring.demo_spring.entities.Seller;
import com.demo.spring.demo_spring.repositories.DepartmentRepository;
import com.demo.spring.demo_spring.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Seller> findAll() {
        return repository.findAll();
    }

    public Seller findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Seller not found"));
    }

    public Seller insert(Seller sel) {
        return repository.save(sel);
    }

    public Seller update(Long id, Seller obj) {
        Seller seller = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        Department dep = departmentRepository.findById(obj.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        seller.setName(obj.getName());
        seller.setEmail(obj.getEmail());
        seller.setBirthDate(obj.getBirthDate());
        seller.setBaseSalary(obj.getBaseSalary());
        seller.setDepartment(dep);

        return repository.save(seller);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
