package com.urjc.shoppingcart.domain.model;

public class Product {
    private String name;
    private String description;
    private Integer quantity;

    public Product(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public Product() {}
}
