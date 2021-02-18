package com.urjc.shoppingcart.domain.dto;

public class ProductRequestDto {
    private String name;
    private String descripcion;
    private Integer quantity;

    public ProductRequestDto(String name, String descripcion, int quantity) {
        this.name = name;
        this.descripcion = descripcion;
        this.quantity = quantity;
    }

    public ProductRequestDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
