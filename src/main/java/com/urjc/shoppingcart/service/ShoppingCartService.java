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

    private ShoppingCartDto toShoppingCartDto(ShoppingCartRequestDto shoppingCartRequestDto) {
        return new ShoppingCartDto(shoppingCartRequestDto.getProducts(), shoppingCartRequestDto.getStatus());
    }
}
