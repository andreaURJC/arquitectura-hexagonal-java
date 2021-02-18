package com.urjc.shoppingcart.domain.usecases;

import com.urjc.shoppingcart.domain.DTO.NewProductDto;
import com.urjc.shoppingcart.domain.DTO.ProductRequestDto;
import com.urjc.shoppingcart.domain.repository.ProductRepository;

public class ProductUseCaseImpl implements ProductUseCase {

    private final ProductRepository productRepository;

    public ProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(ProductRequestDto productRequest) {
        NewProductDto product = new NewProductDto(
                productRequest.getName(),
                productRequest.getDescripcion(),
                productRequest.getQuantity());
        this.productRepository.save(product);
    }
}
