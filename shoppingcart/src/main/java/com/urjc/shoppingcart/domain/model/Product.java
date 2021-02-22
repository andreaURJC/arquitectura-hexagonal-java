package com.urjc.shoppingcart.domain.model;

import com.urjc.shoppingcart.infraestructure.model.ProductEntity;

public class Product {
    int id;
    private String name;
    private String description;

    public Product(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product() {}

    public ProductEntity toEntity() {
        return new ProductEntity(this.getId(), this.getName(), this.getDescription());
    }
}
