package com.demo.spring.demo_spring.controllers;

import com.demo.spring.demo_spring.entities.Seller;
import com.demo.spring.demo_spring.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    private SellerService service;

    @GetMapping
    public List<Seller> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Seller findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Seller insert(@RequestBody Seller sel) {
        return service.insert(sel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Seller update(@PathVariable Long id, @RequestBody Seller sel) {
        return service.update(id, sel);
    }
}
