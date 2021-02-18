package com.urjc.shoppingcart.domain.repository;

import com.urjc.shoppingcart.domain.dto.FullProductDto;

import java.util.List;

public interface ProductRepository {
    FullProductDto save(FullProductDto fullProductDto);
    List<FullProductDto> findAll();
}
