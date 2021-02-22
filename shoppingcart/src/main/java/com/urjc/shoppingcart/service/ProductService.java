package com.urjc.shoppingcart.service;

import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.dto.ProductDto;
import com.urjc.shoppingcart.domain.dto.ProductRequestDto;
import com.urjc.shoppingcart.domain.usecases.ProductUseCase;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductUseCase productUseCase;
    private DozerBeanMapper mapper = new DozerBeanMapper();

    public ProductService(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    public FullProductDto createProduct(ProductRequestDto productRequestDto) {

        return this.productUseCase.save(toProductDto(productRequestDto));
    }

    public List<FullProductDto> getAllProducts() {
        return this.productUseCase.getAllProducts();
    }

    public Optional<FullProductDto> findById(int id) {
        return this.productUseCase.findById(id);
    }

    private ProductDto toProductDto(ProductRequestDto productRequest) {
        return mapper.map(productRequest, ProductDto.class);
    }

    public Optional<FullProductDto> delete(int id) {
        return this.productUseCase.delete(id);
    }
}
