package com.urjc.shoppingcartvalidator.service;

import com.urjc.shoppingcartvalidator.controller.ShoppingCartRequestDto;
import com.urjc.shoppingcartvalidator.domain.ShoppingCart;
import com.urjc.shoppingcartvalidator.domain.ShoppingCartValidatorUserCase;
import com.urjc.shoppingcartvalidator.domain.ValidatorException;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartValidatorService {
    private final ShoppingCartValidatorUserCase shoppingCartValidatorUserCase;

    public ShoppingCartValidatorService(ShoppingCartValidatorUserCase shoppingCartValidatorUserCase) {
        this.shoppingCartValidatorUserCase = shoppingCartValidatorUserCase;
    }

    public boolean validateShoppingCart(ShoppingCartRequestDto shoppingCartRequestDto) throws ValidatorException {
        ShoppingCart shoppingCart = new ShoppingCart(shoppingCartRequestDto.getId());
        return this.shoppingCartValidatorUserCase.validateShoppingCart(shoppingCart);
    }
}
