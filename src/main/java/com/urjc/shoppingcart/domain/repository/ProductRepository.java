package com.urjc.shoppingcart.domain.repository;

import com.urjc.shoppingcart.domain.dto.FullProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    FullProductDto save(FullProductDto fullProductDto);
    List<FullProductDto> findAll();
    Optional<FullProductDto> findById(int id);
    Optional<FullProductDto> delete(int id);
}
