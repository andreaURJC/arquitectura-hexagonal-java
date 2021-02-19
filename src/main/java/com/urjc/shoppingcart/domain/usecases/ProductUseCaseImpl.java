package com.urjc.shoppingcart.domain.usecases;

import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.dto.ProductDto;
import com.urjc.shoppingcart.domain.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductUseCaseImpl implements ProductUseCase {

    private final ProductRepository productRepository;

    public ProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public FullProductDto save(ProductDto productDto) {
        FullProductDto product = toFullBookDto(productDto);
        return this.productRepository.save(product);
    }

    @Override
    public List<FullProductDto> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<FullProductDto> findById(int id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Optional<FullProductDto> delete(int id) {
        return this.productRepository.delete(id);
    }

    private FullProductDto toFullBookDto(ProductDto productDto) {
        return new FullProductDto(productDto.getName(), productDto.getDescription(), productDto.getQuantity());
    }

}
