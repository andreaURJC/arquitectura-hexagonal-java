package com.urjc.shoppingcart.domain.dto;

public class ProductSavedDto {
    private int id;
    private String name;
    private String description;
    private Integer quantity;

    public ProductSavedDto(int id, String name, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }
}
