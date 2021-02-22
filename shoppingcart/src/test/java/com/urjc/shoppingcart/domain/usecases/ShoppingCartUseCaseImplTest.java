package com.urjc.shoppingcart.domain.usecases;

import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.dto.FullShoppingCartDto;
import com.urjc.shoppingcart.domain.model.CartStatus;
import com.urjc.shoppingcart.domain.repository.ProductRepository;
import com.urjc.shoppingcart.domain.repository.ShoppingCartRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
class ShoppingCartUseCaseImplTest {
    @Mock
    private ShoppingCartRepository shoppingCartRepository;
    @Mock
    private ProductRepository productRepository;

    private ShoppingCartUseCase shoppingCartUseCase;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.shoppingCartUseCase = new ShoppingCartUseCaseImpl(shoppingCartRepository, productRepository);
    }

    @Test
    void whenCreateShoppingCart_thenReturnNewShoppingCartStatusCreated() {
        FullShoppingCartDto shoppingCart = new FullShoppingCartDto(1, null, CartStatus.CREATED);
        Mockito.when(this.shoppingCartRepository.save()).thenReturn(shoppingCart);

        Assertions.assertEquals(this.shoppingCartUseCase.create().getStatus(), CartStatus.CREATED);
        Assertions.assertEquals(this.shoppingCartUseCase.create().getId(), 1);
    }

    @Test
    void givenExistingCartAndExistingProduct_whenSaveOneProductToShoppingCart_thenReturnNewShoppingCartStatusInProgressAndNewProductInProducts() {
        FullShoppingCartDto shoppingCart = new FullShoppingCartDto(1, new ArrayList<>(), CartStatus.CREATED);
        FullProductDto product = new FullProductDto(1, "Alexa", "Description");

        Mockito.when(this.shoppingCartRepository.findById(1)).thenReturn(Optional.of(shoppingCart));
        Mockito.when(this.productRepository.findById(1)).thenReturn(Optional.of(product));
        Mockito.when(this.shoppingCartRepository.save()).thenReturn(shoppingCart);

        FullShoppingCartDto updatedShoppingCart = this.shoppingCartUseCase.saveProduct(1, 1, 1).get();

        Assertions.assertEquals(updatedShoppingCart.getProducts().stream().findFirst().get().getName(), product.getName());
        Assertions.assertEquals(updatedShoppingCart.getProducts().size(), 1);
        Assertions.assertEquals(updatedShoppingCart.getStatus(), CartStatus.INPROGRESS);
    }

    //TODO: test when adding multiple values
//    @Test
//    void givenExistingCartAndExistingProduct_whenSaveMultipleProductsToShoppingCart_thenReturnNewShoppingCartStatusInProgressAndNewProductInProducts() {
//
//    }

}