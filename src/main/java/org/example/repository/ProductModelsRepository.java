package org.example.repository;

import org.example.model.ProductModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductModelsRepository extends JpaRepository<ProductModels, Long> {
    List<ProductModels> findByCategoryId(Long categoryId);
}
