package com.urjc.shoppingcart.infraestructure.model;

import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.model.Product;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Integer quantity;
//    @ManyToMany(mappedBy = "products")
//    private List<ShoppingCartEntity> shoppingCarts;

    public ProductEntity(String name, String description, Integer quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public ProductEntity(Integer id, String name, String description, Integer quantity) {
        if (id != null) {
            this.id = id;
        }
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public ProductEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product toProduct() {
        return new Product(this.getId(), this.getName(), this.getDescription(), this.getQuantity());
    }

}
