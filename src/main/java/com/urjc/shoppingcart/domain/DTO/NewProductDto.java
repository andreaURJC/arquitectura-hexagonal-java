package com.urjc.shoppingcart.domain.DTO;

public class NewProductDto {
    private String name;
    private String descripcion;
    private Integer quantity;

    public NewProductDto(String name, String descripcion, int quantity) {
        this.name = name;
        this.descripcion = descripcion;
        this.quantity = quantity;
    }

    public NewProductDto() {}

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
