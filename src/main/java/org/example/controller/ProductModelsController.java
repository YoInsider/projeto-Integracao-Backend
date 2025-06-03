package org.example.controller;

import org.example.model.ProductModels;
import org.example.repository.ProductModelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/modelos")
public class ProductModelsController {

     @Autowired
    private ProductModelsRepository repo;

    @GetMapping
    public List<ProductModels> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public List<ProductModels> getById(@PathVariable Long id) {
        return repo.findByCategoryId(id);
    }
}
