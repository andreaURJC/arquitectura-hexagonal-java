package com.urjc.shoppingcartvalidator.domain;

public interface ShoppingCartValidatorUserCase {
    boolean validateShoppingCart(ShoppingCart shoppingCart) throws ValidatorException;
}
