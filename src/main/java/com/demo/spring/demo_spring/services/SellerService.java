package com.demo.spring.demo_spring.services;

import com.demo.spring.demo_spring.entities.Seller;
import com.demo.spring.demo_spring.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<Seller> findAll() {
        return repository.findAll();
    }

    public Seller findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Seller not found"));
    }

    public Seller insert(Seller sel) {
        return repository.save(sel);
    }

    public Seller update(Long id, Seller sel) {
        Seller obj = repository.findById(id).orElseThrow(() -> new RuntimeException("Seller not found"));
        obj.setName(sel.getName());
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
