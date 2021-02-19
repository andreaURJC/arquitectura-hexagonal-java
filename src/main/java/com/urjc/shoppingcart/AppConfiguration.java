package com.urjc.shoppingcart;

import com.urjc.shoppingcart.domain.repository.ProductRepository;
import com.urjc.shoppingcart.domain.usecases.ProductUseCase;
import com.urjc.shoppingcart.domain.usecases.ProductUseCaseImpl;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class AppConfiguration {
    @Bean
    public ProductUseCase productUseCase(ProductRepository productRepositoryAdapter) {
        return new ProductUseCaseImpl(productRepositoryAdapter);
    }

}
