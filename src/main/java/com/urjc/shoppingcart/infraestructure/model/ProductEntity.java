package com.urjc.shoppingcart.infraestructure.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String descripcion;
    private Integer quantity;


    public ProductEntity(String name, String descripcion, Integer quantity) {
        this.name = name;
        this.descripcion = descripcion;
        this.quantity = quantity;
    }

    public ProductEntity() {}
}
