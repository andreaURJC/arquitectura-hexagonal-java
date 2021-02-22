package com.urjc.shoppingcart.domain.usecases;

import com.urjc.shoppingcart.domain.dto.FullShoppingCartDto;

import java.util.Optional;

public interface ShoppingCartUseCase {
    FullShoppingCartDto create();
    Optional<FullShoppingCartDto> delete(int id);
    Optional<FullShoppingCartDto> finish(int id);
    Optional<FullShoppingCartDto> findById(int id);
    Optional<FullShoppingCartDto> saveProduct(int productId, int shoppingCartId, int quantity);
    Optional<FullShoppingCartDto> deleteProduct(int productId, int shoppingCartId);
}
