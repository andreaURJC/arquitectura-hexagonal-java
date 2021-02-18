package com.urjc.shoppingcart;

import com.urjc.shoppingcart.domain.usecases.ProductUseCase;
import com.urjc.shoppingcart.domain.usecases.ProductUseCaseImpl;
import com.urjc.shoppingcart.infraestructure.adapters.ProductRepositoryAdapter;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class AppConfiguration {
    @Bean
    public ProductUseCase productUseCase(ProductRepositoryAdapter productRepositoryAdapter) {
        return new ProductUseCaseImpl(productRepositoryAdapter);
    }
}
