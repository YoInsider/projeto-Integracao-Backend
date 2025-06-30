package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "product_categories")
public class ProductCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "line_id")
    private ProductLines line;

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
}
