package com.urjc.shoppingcart.domain.usecases;

import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.dto.FullShoppingCartDto;
import com.urjc.shoppingcart.domain.model.CartStatus;
import com.urjc.shoppingcart.domain.model.Product;
import com.urjc.shoppingcart.domain.repository.ProductRepository;
import com.urjc.shoppingcart.domain.repository.ShoppingCartRepository;

import java.util.Optional;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    public ShoppingCartUseCaseImpl(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
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
        Optional<FullShoppingCartDto> shoppingCart = this.shoppingCartRepository.findById(id);
        shoppingCart.ifPresent(cart -> {
            cart.setProducts(cart.getProducts());
        });
        return shoppingCart;
    }

    @Override
    public Optional<FullShoppingCartDto> saveProduct(int productId, int shoppingCartId, int quantity) {
        Optional<FullProductDto> fullProductDto = this.productRepository.findById(productId);
        Optional<FullShoppingCartDto> shoppingCart = this.shoppingCartRepository.findById(shoppingCartId);

        fullProductDto.ifPresent(product -> shoppingCart.ifPresent(cart -> {
            for (int i = 0; i < quantity; i++) {
                cart.getProducts().add(toProduct(product));
            }
            cart.setStatus(CartStatus.INPROGRESS);
            this.shoppingCartRepository.save(cart);
        }));

        return shoppingCart;
    }

    @Override
    public Optional<FullShoppingCartDto> deleteProduct(int productId, int shoppingCartId) {
        Optional<FullProductDto> fullProductDto = this.productRepository.findById(productId);
        Optional<FullShoppingCartDto> shoppingCart = this.shoppingCartRepository.findById(shoppingCartId);

        fullProductDto.ifPresent(product -> shoppingCart.ifPresent(cart -> {
            cart.getProducts().add(toProduct(product));
            Product productToDelete = cart.getProducts().stream().filter(product1 -> product.getName().equals(product.getName())).findFirst().get();
            cart.getProducts().remove(cart.getProducts().indexOf(productToDelete));
        }));

        return shoppingCart;
    }

    private Product toProduct(FullProductDto fullProductDto) {
        return new Product(fullProductDto.getId(), fullProductDto.getName(), fullProductDto.getDescription());
    }

}
