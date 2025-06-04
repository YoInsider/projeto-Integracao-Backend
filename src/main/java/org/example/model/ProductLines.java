package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_lines")
public class ProductLines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "line")
    private List<ProductCategories> categories;

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

    public List<ProductCategories> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductCategories> categories) {
        this.categories = categories;
    }
}
