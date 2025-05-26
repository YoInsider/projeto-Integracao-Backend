package org.example.model;

public enum ProductLines {
    CRONOS("Cronos"),
    ARES("Ares");

    private final String nome;

    ProductLines(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return nome;
    }
}
