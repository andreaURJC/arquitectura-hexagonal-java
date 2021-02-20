package com.urjc.shoppingcart.domain.dto;

import com.urjc.shoppingcart.domain.model.CartStatus;
import com.urjc.shoppingcart.domain.model.Product;

import java.util.List;

public class ShoppingCartDto {
    List<Product> products;
    CartStatus status;

    public ShoppingCartDto(List<Product> products, CartStatus status) {
        this.products = products;
        this.status = status;
    }

    public ShoppingCartDto() {
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
