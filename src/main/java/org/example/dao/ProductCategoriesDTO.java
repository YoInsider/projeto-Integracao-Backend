package org.example.dao;

import org.example.model.ProductLines;

public class ProductCategoriesDTO {

    private Long id;
    private String name;
    private ProductLinesDTO line;

    public ProductCategoriesDTO() {}

    public ProductCategoriesDTO(Long id, String name, ProductLinesDTO line) {
        this.id = id;
        this.name = name;
        this.line = line;
    }

    public ProductCategoriesDTO(Long id, String name, ProductLines line) {}

    public ProductCategoriesDTO(Long id, String name) {
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

    public ProductLinesDTO getLine() {
        return line;
    }

    public void setLine(ProductLinesDTO line) {
        this.line = line;
    }

    public String toString() {
        return name;
    }
}
