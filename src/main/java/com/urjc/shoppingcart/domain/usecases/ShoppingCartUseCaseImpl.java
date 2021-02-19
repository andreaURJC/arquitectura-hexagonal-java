package com.urjc.shoppingcart.domain.usecases;

import com.urjc.shoppingcart.domain.dto.FullShoppingCartDto;
import com.urjc.shoppingcart.domain.dto.ShoppingCartDto;
import com.urjc.shoppingcart.domain.model.CartStatus;
import com.urjc.shoppingcart.domain.repository.ShoppingCartRepository;

import java.util.Optional;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartUseCaseImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public FullShoppingCartDto create() {
        return this.shoppingCartRepository.save();
    }

    @Override
    public Optional<FullShoppingCartDto> delete(int id) {
        Optional<FullShoppingCartDto> shoppingCart = this.shoppingCartRepository.findById(id);
        shoppingCart.ifPresent(this.shoppingCartRepository::delete);
        return shoppingCart;
    }

    @Override
    public Optional<FullShoppingCartDto> finish(int id) {
        Optional<FullShoppingCartDto> shoppingCart = this.shoppingCartRepository.findById(id);
        shoppingCart.ifPresent(cart -> {
            cart.setStatus(CartStatus.FINISHED);
            this.shoppingCartRepository.finish(cart);
        });
        return shoppingCart;
    }

    @Override
    public Optional<FullShoppingCartDto> findById(int id) {
        return this.shoppingCartRepository.findById(id);
    }

    @Override
    public FullShoppingCartDto saveProduct(int productId, int shoppingCartId, int quantity) {
        return null;
    }

    @Override
    public FullShoppingCartDto deleteProduct(int productId, int shoppingCartId) {
        return null;
    }

}
