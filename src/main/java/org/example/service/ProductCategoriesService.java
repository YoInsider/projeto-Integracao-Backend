package org.example.service;

import org.example.dao.ProductCategoriesDTO;
import org.example.dao.ProductLinesDTO;
import org.example.model.ProductCategories;
import org.example.repository.ProductCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoriesService {

    @Autowired
    private ProductCategoriesRepository repo;

    public List<ProductCategoriesDTO> getAllCategories() {
        return repo.findAll()
                .stream()
                .map(cat -> new ProductCategoriesDTO(cat.getId(), cat.getName(), new ProductLinesDTO(cat.getLine().getId(), cat.getLine().getName())))
                .collect(Collectors.toList());
    }

    public List<ProductCategoriesDTO> getCategoryByLineId(Long id) {
        if(repo.existsById(id)) {
            List<ProductCategories> category = repo.findByLineId(id);
            List<ProductCategoriesDTO> categoryDTO = category
                    .stream()
                    .map(cat -> new ProductCategoriesDTO(cat.getId(), cat.getName(), new ProductLinesDTO(cat.getLine().getId(), cat.getLine().getName())))
                    .collect(Collectors.toList());
            return categoryDTO;
        } else {
            throw new EntityNotFoundException("Category %s doesn't have a related line");
        }
    }
}
