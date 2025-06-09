package org.example.repository;

import org.example.model.ProductLines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductLinesRepository extends JpaRepository<ProductLines, Long> {
    ProductLines findLineById(Long id);
}
