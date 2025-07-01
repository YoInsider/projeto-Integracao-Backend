package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "product_models")
public class ProductModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategories category;

    public ProductModels(Long id, String name, ProductCategories category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
