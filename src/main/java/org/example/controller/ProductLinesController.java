package org.example.controller;

import org.example.model.ProductLines;
import org.example.repository.ProductLinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/linhas")
public class ProductLinesController {

    @Autowired
    private ProductLinesRepository repo;

    @GetMapping
    public List<ProductLines> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public List<ProductLines> getById(@PathVariable Long id) {
        return repo.findLineById(id);
    }
}
