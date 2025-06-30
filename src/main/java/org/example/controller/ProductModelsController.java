package org.example.controller;

import org.example.dao.ProductModelsDTO;
import org.example.model.ProductModels;
import org.example.repository.ProductModelsRepository;
import org.example.service.ProductModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ProductModelsController {

     @Autowired
     private ProductModelsService service;

    @GetMapping
    public List<ProductModelsDTO> getAll() {
        return service.getAllModels();
    }

    @GetMapping("/{id}")
    public List<ProductModelsDTO> getById(@PathVariable Long id) {
        return service.getModelByCategoryId(id);
    }
}
