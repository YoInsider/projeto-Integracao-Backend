package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_categories")
public class ProductCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "line_id")
    private ProductLines line;

    @OneToMany(mappedBy = "category")
    private List<ProductModels> models;

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

    public ProductLines getLine() {
        return line;
    }

    public void setLine(ProductLines line) {
        this.line = line;
    }

    public List<ProductModels> getModels() {
        return models;
    }

    public void setModels(List<ProductModels> models) {
        this.models = models;
    }
}
