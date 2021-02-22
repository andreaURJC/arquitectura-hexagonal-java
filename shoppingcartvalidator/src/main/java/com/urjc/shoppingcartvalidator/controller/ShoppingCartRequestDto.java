package com.urjc.shoppingcartvalidator.controller;

public class ShoppingCartRequestDto {
    private int id;

    public ShoppingCartRequestDto(int id) {
        this.id = id;
    }

    public ShoppingCartRequestDto() {
    }

    public int getId(){
        return this.id;
    }
}
