package com.urjc.shoppingcart.infraestructure.model;

import com.urjc.shoppingcart.domain.model.CartStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "shopping_cart_product",
            joinColumns = {@JoinColumn(name = "shopping_cart_entity_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_entity_id")})
    private List<ProductEntity> products;
    private CartStatus status;

    public ShoppingCartEntity(List<ProductEntity> products, CartStatus status) {
        this.products = products;
        this.status = status;
    }

    public ShoppingCartEntity(Integer id, List<ProductEntity> products, CartStatus status) {
        if (id != null) {
            this.id = id;
        }
        this.products = products;
        this.status = status;
    }

    public ShoppingCartEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ProductEntity> getProducts() {
        return products;
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
