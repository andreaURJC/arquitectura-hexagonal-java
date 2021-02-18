package com.urjc.shoppingcart.domain.usecases;

import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.dto.ProductDto;

import java.util.List;

public interface ProductUseCase {
    FullProductDto save(ProductDto productRequest);
    List<FullProductDto> getAllProducts();
}
