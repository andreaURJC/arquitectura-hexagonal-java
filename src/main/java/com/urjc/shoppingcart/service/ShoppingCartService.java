package com.urjc.shoppingcart.service;

import com.urjc.shoppingcart.controller.dto.ShoppingCartRequestDto;
import com.urjc.shoppingcart.domain.dto.FullShoppingCartDto;
import com.urjc.shoppingcart.domain.dto.ShoppingCartDto;
import com.urjc.shoppingcart.domain.usecases.ShoppingCartUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartService {
    private final ShoppingCartUseCase shoppingCartUseCase;

    public ShoppingCartService(ShoppingCartUseCase shoppingCartUseCase) {
        this.shoppingCartUseCase = shoppingCartUseCase;
    }

    public FullShoppingCartDto create() {
        return this.shoppingCartUseCase.create();
    }

    public Optional<FullShoppingCartDto> delete(int id) {
        return this.shoppingCartUseCase.delete(id);
    }

    public Optional<FullShoppingCartDto> finish(int id) {
       return this.shoppingCartUseCase.finish(id);
    }

    public Optional<FullShoppingCartDto> findById(int id) {
        return this.shoppingCartUseCase.findById(id);
    }

    public Optional<FullShoppingCartDto> saveProduct(int productId, int shoppingCartId, int quantity) {
        return this.shoppingCartUseCase.saveProduct(productId, shoppingCartId,quantity);
    }

    public Optional<FullShoppingCartDto> deleteProduct(int productId, int shoppingCartId) {
        return this.shoppingCartUseCase.deleteProduct(productId,shoppingCartId);
    }
}
