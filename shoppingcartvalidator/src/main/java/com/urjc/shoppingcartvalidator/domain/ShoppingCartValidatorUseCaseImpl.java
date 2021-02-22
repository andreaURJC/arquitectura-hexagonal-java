package com.urjc.shoppingcartvalidator.domain;

public class ShoppingCartValidatorUseCaseImpl implements ShoppingCartValidatorUserCase {
    @Override
    public boolean validateShoppingCart(ShoppingCart shoppingCart) throws ValidatorException {
        boolean result;
        try {
            result = shoppingCart.getId() % 2 == 0 ? true : false;
        } catch (Exception ex) {
            throw new ValidatorException(ex);
        }
        return result;
    }
}

