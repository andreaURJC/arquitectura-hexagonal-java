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
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<ProductEntity> products;
    private CartStatus status;

    public ShoppingCartEntity(List<ProductEntity> products, CartStatus status) {
        this.products = products;
        this.status = status;
    }

    public ShoppingCartEntity(Integer productId, List<ProductEntity> products, CartStatus status) {
        if (productId != null) {
            this.productId = productId;
        }
        this.products = products;
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

    public List<ProductEntity> getProducts() {
        return new ArrayList<>();
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }
}
