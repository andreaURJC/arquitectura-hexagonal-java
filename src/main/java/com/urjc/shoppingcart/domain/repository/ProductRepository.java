package com.urjc.shoppingcart.domain.repository;

import com.urjc.shoppingcart.domain.DTO.NewProductDto;

public interface ProductRepository {
    void save(NewProductDto productRequestDto);
}
