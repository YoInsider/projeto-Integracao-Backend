package org.example.dao;

import org.example.model.ProductCategories;

public class ProductModelsDTO {

    private Long id;
    private String name;
    private ProductCategories category;

    public ProductModelsDTO() {}

    public ProductModelsDTO(Long id, String name, ProductCategories category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategories getCategory() {
        return category;
    }

    public void setCategory(ProductCategories category) {
        this.category = category;
    }

    public String toString() {
        return name;
    }
}
