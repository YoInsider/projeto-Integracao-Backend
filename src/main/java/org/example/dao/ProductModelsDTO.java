package org.example.dao;

public class ProductModelsDTO {

    private Long id;
    private String name;
    private ProductCategoriesDTO category;

    public ProductModelsDTO() {}

    public ProductModelsDTO(Long id, String name, ProductCategoriesDTO category) {
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

    public ProductCategoriesDTO getCategory() {
        return category;
    }

    public void setCategory(ProductCategoriesDTO category) {
        this.category = category;
    }

    public String toString() {
        return name;
    }
}
