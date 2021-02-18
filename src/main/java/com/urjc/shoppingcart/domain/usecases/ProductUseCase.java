package com.urjc.shoppingcart.domain.usecases;

import com.urjc.shoppingcart.domain.dto.ProductRequestDto;
import com.urjc.shoppingcart.domain.dto.ProductResponseDto;

import java.util.List;

public interface ProductUseCase {
    ProductResponseDto save(ProductRequestDto productRequest);
    List<ProductResponseDto> getAll();
}
