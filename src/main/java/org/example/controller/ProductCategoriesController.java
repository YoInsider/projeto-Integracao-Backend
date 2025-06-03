package org.example.controller;

import org.example.model.ProductCategories;
import org.example.repository.ProductCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class ProductCategoriesController {

    @Autowired
    private ProductCategoriesRepository repo;

    @GetMapping
    public List<ProductCategories> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public List<ProductCategories> getById(@PathVariable Long id) {
        return repo.findByLineId(id);
    }
}
