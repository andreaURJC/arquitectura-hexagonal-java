package com.urjc.shoppingcart;

import com.urjc.shoppingcart.domain.repository.ProductRepository;
import com.urjc.shoppingcart.domain.repository.ShoppingCartRepository;
import com.urjc.shoppingcart.domain.usecases.ProductUseCase;
import com.urjc.shoppingcart.domain.usecases.ProductUseCaseImpl;
import com.urjc.shoppingcart.domain.usecases.ShoppingCartUseCase;
import com.urjc.shoppingcart.domain.usecases.ShoppingCartUseCaseImpl;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class AppConfiguration {
    @Bean
    public ProductUseCase productUseCase(ProductRepository productRepositoryAdapter) {
        return new ProductUseCaseImpl(productRepositoryAdapter);
    }

    @Bean
    public ShoppingCartUseCase shoppingCartUseCase(ShoppingCartRepository shoppingCartRepositoryAdapter, ProductRepository productRepositoryAdapter) {
        return new ShoppingCartUseCaseImpl(shoppingCartRepositoryAdapter, productRepositoryAdapter);
    }
}
