package com.urjc.shoppingcart.infraestructure.model;

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
    @ManyToMany(mappedBy = "products")
    private List<ShoppingCartEntity> shoppingCarts;

    public ProductEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProductEntity(Integer id, String name, String description) {
        if (id != null) {
            this.id = id;
        }
        this.name = name;
        this.description = description;
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

    public Product toProduct() {
        return new Product(this.getId(), this.getName(), this.getDescription());
    }

}
