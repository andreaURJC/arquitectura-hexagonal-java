package com.urjc.shoppingcart.domain.dto;

import com.urjc.shoppingcart.domain.model.CartStatus;
import com.urjc.shoppingcart.domain.model.Product;

import java.util.List;

public class FullShoppingCartDto {
    Integer id;
    CartStatus status;

    public FullShoppingCartDto(Integer id, CartStatus status) {
        this.id = id;
        this.status = status;
    }

    public FullShoppingCartDto(CartStatus status) {
        this.status = status;
    }

    public FullShoppingCartDto() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }
}
