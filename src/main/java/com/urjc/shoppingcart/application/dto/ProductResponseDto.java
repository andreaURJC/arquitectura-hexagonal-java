package com.urjc.shoppingcart.application.dto;

public class ProductResponseDto {
    private int id;
    private String name;
    private String description;
    private Integer quantity;

    public ProductResponseDto(int id, String name, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }
}
