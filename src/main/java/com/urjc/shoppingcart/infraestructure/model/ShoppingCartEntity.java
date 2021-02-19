package com.urjc.shoppingcart.infraestructure.model;

import com.urjc.shoppingcart.domain.model.CartStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private CartStatus status;

    public ShoppingCartEntity( CartStatus status) {

        this.status = status;
    }

    public ShoppingCartEntity(Integer productId, CartStatus status) {
        if (productId != null) {
            this.productId = productId;
        }
        this.status = status;
    }

    public ShoppingCartEntity() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer id) {
        this.productId = id;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }
}
