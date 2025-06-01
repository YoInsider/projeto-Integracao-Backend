package org.example;

import org.example.model.ProductLines;
import org.example.repository.ProductLinesRepository;

public class Main {
    public static void main(String[] args) {

        ProductLinesRepository repo = new ProductLinesRepository();
        for (ProductLines line : repo.findAll()) {
            System.out.println("Linha: "+line.getName());
            if (line.getCategories() != null) {
                line.getCategories().forEach(cat -> {
                    System.out.println("Categorias: "+cat.getName());
                    if(cat.getModels() != null) {
                        cat.getModels().forEach(model -> {
                            System.out.println("Modelos: "+model.getName());
                        });
                    }
                });
            }
        }
    }
}