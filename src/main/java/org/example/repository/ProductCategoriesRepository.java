package org.example.repository;

import org.example.model.ProductCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoriesRepository extends JpaRepository<ProductCategories, Long> {
    List<ProductCategories> findByLineId(Long lineId);
}
