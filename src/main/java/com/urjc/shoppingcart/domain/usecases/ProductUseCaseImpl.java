package com.urjc.shoppingcart.domain.usecases;

import com.urjc.shoppingcart.domain.dto.NewProductDto;
import com.urjc.shoppingcart.domain.dto.ProductRequestDto;
import com.urjc.shoppingcart.domain.dto.ProductResponseDto;
import com.urjc.shoppingcart.domain.repository.ProductRepository;
import org.dozer.DozerBeanMapper;

public class ProductUseCaseImpl implements ProductUseCase {

    private final ProductRepository productRepository;

    private final DozerBeanMapper mapper = new DozerBeanMapper();

    public ProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto save(ProductRequestDto productRequest) {
        NewProductDto product = mapper.map(productRequest, NewProductDto.class);
        return mapper.map(this.productRepository.save(product), ProductResponseDto.class);
    }
}
