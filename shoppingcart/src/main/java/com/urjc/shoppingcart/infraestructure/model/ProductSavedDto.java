package com.urjc.shoppingcart.infraestructure.model;

public class ProductSavedDto {
    private int id;
    private String name;
    private String description;

    public ProductSavedDto(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ProductSavedDto() {}

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
}
