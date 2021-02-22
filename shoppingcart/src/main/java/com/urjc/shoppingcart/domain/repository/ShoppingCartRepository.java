package com.urjc.shoppingcart.domain.repository;

import com.urjc.shoppingcart.domain.dto.FullShoppingCartDto;

import java.util.Optional;

public interface ShoppingCartRepository {
    FullShoppingCartDto save();
    FullShoppingCartDto save(FullShoppingCartDto shoppingCartDto);
    FullShoppingCartDto delete(FullShoppingCartDto fullShoppingCartDto);
    FullShoppingCartDto finish(FullShoppingCartDto shoppingCartDto);
    Optional<FullShoppingCartDto> findById(int id);
    Optional<FullShoppingCartDto> saveProduct(int productId, int shoppingCartId, int quantity);
    Optional<FullShoppingCartDto> deleteProduct(int productId, int shoppingCartId);
}
