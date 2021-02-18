package com.urjc.shoppingcart.domain.usecases;

import com.urjc.shoppingcart.domain.DTO.ProductRequestDto;

public interface ProductUseCase {
    void save(ProductRequestDto productRequest);
}
