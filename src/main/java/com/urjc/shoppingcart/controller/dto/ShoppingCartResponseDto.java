package com.urjc.shoppingcart.controller.dto;

import com.urjc.shoppingcart.domain.model.CartStatus;
import com.urjc.shoppingcart.domain.model.Product;

import java.util.List;

public class ShoppingCartResponseDto {
    int id;
    CartStatus status;

    public ShoppingCartResponseDto(Integer id, CartStatus status) {
        this.id = id;
        this.status = status;
    }

    public ShoppingCartResponseDto() {
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
