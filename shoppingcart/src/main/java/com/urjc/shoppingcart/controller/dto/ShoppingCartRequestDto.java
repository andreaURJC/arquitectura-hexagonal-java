package com.urjc.shoppingcart.controller.dto;

import com.urjc.shoppingcart.domain.model.CartStatus;
import com.urjc.shoppingcart.domain.model.Product;

import java.util.List;

public class ShoppingCartRequestDto {
    List<Product> products;
    CartStatus status;

    public ShoppingCartRequestDto(List<Product> products, CartStatus status) {
        this.products = products;
        this.status = status;
    }

    public ShoppingCartRequestDto() {
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
}
