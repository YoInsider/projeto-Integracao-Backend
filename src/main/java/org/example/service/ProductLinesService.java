package org.example.service;

import org.example.dao.ProductLinesDTO;
import org.example.model.ProductLines;
import org.example.repository.ProductLinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductLinesService {

    @Autowired
    private ProductLinesRepository repo;

    public List<ProductLinesDTO> getAllLines() {
        return repo.findAll()
                .stream()
                .map(entity -> new ProductLinesDTO(entity.getId(), entity.getName()))
                .collect(Collectors.toList());
    }

    public String getLineById(Long id) {
        if (repo.existsById(id)) {
            ProductLines line = repo.findLineById(id);
            ProductLinesDTO lineDTO = new ProductLinesDTO(line.getId(), line.getName());
            return lineDTO.getName();
        } else {
            return String.format("Id %s doesn't have a related line.", id);
        }
    }
}
