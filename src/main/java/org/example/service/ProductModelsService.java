package org.example.service;

import org.example.dao.ProductModelsDTO;
import org.example.model.ProductModels;
import org.example.repository.ProductModelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductModelsService {

    @Autowired
    private ProductModelsRepository repo;

    public List<ProductModelsDTO> getAllModels() {
        return repo.findAll()
                .stream()
                .map(m -> new ProductModelsDTO(m.getId(), m.getName()))
                .collect(Collectors.toList());
    }

    public List<ProductModelsDTO> getModelByCategoryId(Long id) {
        if (repo.existsById(id)) {
            List<ProductModels> model = repo.findByCategoryId(id);
            List<ProductModelsDTO> modelDTO = model
                    .stream()
                    .map(m -> new ProductModelsDTO(m.getId(), m.getName(), m.getCategory()))
                    .collect(Collectors.toList());
            return modelDTO;
        } else {
            throw new EntityNotFoundException("Models %s doesn't have a related category");
        }
    }
}
