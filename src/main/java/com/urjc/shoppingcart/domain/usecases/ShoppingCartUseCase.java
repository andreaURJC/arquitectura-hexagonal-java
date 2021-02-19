package com.urjc.shoppingcart.domain.usecases;

import com.urjc.shoppingcart.domain.dto.FullShoppingCartDto;

import java.util.Optional;

public interface ShoppingCartUseCase {
    FullShoppingCartDto create();
    Optional<FullShoppingCartDto> delete(int id);
    Optional<FullShoppingCartDto> finish(int id);
    Optional<FullShoppingCartDto> findById(int id);
    FullShoppingCartDto saveProduct(int productId, int shoppingCartId, int quantity);
    FullShoppingCartDto deleteProduct(int productId, int shoppingCartId);
}
