package com.urjc.shoppingcart.domain.dto;

import com.urjc.shoppingcart.domain.model.CartStatus;
import com.urjc.shoppingcart.domain.model.Product;
import com.urjc.shoppingcart.infraestructure.model.ProductEntity;

import java.util.List;

public class FullShoppingCartDto {
    Integer id;
    List<Product> products;
    CartStatus status;

    public FullShoppingCartDto(Integer id, List<Product> products, CartStatus status) {
        this.id = id;
        this.products = products;
        this.status = status;
    }

    public FullShoppingCartDto(List<Product> products, CartStatus status) {
        this.products = products;
        this.status = status;
    }

    public FullShoppingCartDto() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
