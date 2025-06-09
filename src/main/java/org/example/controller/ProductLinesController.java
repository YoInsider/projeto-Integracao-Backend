package org.example.controller;

import org.example.dao.ProductLinesDTO;
import org.example.service.ProductLinesService;
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
    private ProductLinesService service;

    @GetMapping
    public List<ProductLinesDTO> getAllLines() {
        return service.getAllLines();
    }

    @GetMapping("/{id}")
    public String getLineById(@PathVariable Long id) {
        return service.getLineById(id);
    }
}
