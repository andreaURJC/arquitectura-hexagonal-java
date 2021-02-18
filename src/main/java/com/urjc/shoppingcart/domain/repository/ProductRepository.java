package com.urjc.shoppingcart.domain.repository;

import com.urjc.shoppingcart.domain.dto.NewProductDto;
import com.urjc.shoppingcart.domain.dto.ProductSavedDto;

public interface ProductRepository {
    ProductSavedDto save(NewProductDto productRequestDto);
}
