package com.urjc.shoppingcart.controller.dto;

public class ProductRequestDto {
    private String name;
    private String description;

    public ProductRequestDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProductRequestDto() {}

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
