package org.example.repository;

import org.example.model.ProductLines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductLinesRepository extends JpaRepository<ProductLines, Long> {
    List<ProductLines> findLineById(Long id);
}
