package com.urjc.shoppingcart.domain.model;

public class Product {
    private String name;
    private String descripcion;
    private Integer quantity;

    public Product(String name, String descripcion, int quantity) {
        this.name = name;
        this.descripcion = descripcion;
        this.quantity = quantity;
    }

    public Product() {}
}
