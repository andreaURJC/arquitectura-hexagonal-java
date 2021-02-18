package com.urjc.shoppingcart.domain.usecases;

import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductUseCase {
    FullProductDto save(ProductDto productRequest);
    List<FullProductDto> getAllProducts();
    Optional<FullProductDto> findById(int id);
    Optional<FullProductDto> delete(int id);
}
