package com.urjc.shoppingcartvalidator;

import com.urjc.shoppingcartvalidator.domain.ShoppingCartValidatorUseCaseImpl;
import com.urjc.shoppingcartvalidator.domain.ShoppingCartValidatorUserCase;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public ShoppingCartValidatorUserCase shoppingCartValidatorUserCase() {
        return new ShoppingCartValidatorUseCaseImpl();
    }
}
