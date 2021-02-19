package com.urjc.shoppingcart.controller.dto;

import com.urjc.shoppingcart.domain.model.CartStatus;
import com.urjc.shoppingcart.domain.model.Product;

import java.util.List;

public class ShoppingCartResponseDto {
    int id;
    List<Product> products;
    CartStatus status;

    public ShoppingCartResponseDto(Integer id,List<Product> products, CartStatus status) {
        this.id = id;
        this.products = products;
        this.status = status;
    }

    public ShoppingCartResponseDto() {
    }

    public List<Product> getProducts() {
        return products;
    }


    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
