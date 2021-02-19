package com.urjc.shoppingcart.infraestructure.adapters;

import com.urjc.shoppingcart.domain.dto.FullShoppingCartDto;
import com.urjc.shoppingcart.domain.model.CartStatus;
import com.urjc.shoppingcart.domain.model.Product;
import com.urjc.shoppingcart.domain.repository.ShoppingCartRepository;
import com.urjc.shoppingcart.infraestructure.model.ProductEntity;
import com.urjc.shoppingcart.infraestructure.model.ShoppingCartEntity;
import com.urjc.shoppingcart.infraestructure.repository.ShoppingCartJpaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ShoppingCartRepositoryAdapter implements ShoppingCartRepository {
    private ShoppingCartJpaRepository shoppingCartJpaRepository;

    public ShoppingCartRepositoryAdapter(ShoppingCartJpaRepository shoppingCartJpaRepository) {
        this.shoppingCartJpaRepository = shoppingCartJpaRepository;
    }

    @Override
    public FullShoppingCartDto save() {
        return toFullShoppingCartDto(this.shoppingCartJpaRepository.save(new ShoppingCartEntity(CartStatus.CREATED)));
    }

    @Override
    public FullShoppingCartDto delete(FullShoppingCartDto fullShoppingCartDto) {
        this.shoppingCartJpaRepository.delete(toEntity(fullShoppingCartDto));
        return fullShoppingCartDto;
    }

    @Override
    public FullShoppingCartDto finish(FullShoppingCartDto fullShoppingCartDto) {
        return toFullShoppingCartDto(this.shoppingCartJpaRepository.save(toEntity(fullShoppingCartDto)));
    }

    @Override
    public Optional<FullShoppingCartDto> findById(int id) {
        Optional<ShoppingCartEntity> shoppingCart = this.shoppingCartJpaRepository.findById(id);
        return shoppingCart.map(this::toFullShoppingCartDto);
    }

    @Override
    public Optional<FullShoppingCartDto> saveProduct(int productId, int shoppingCartId, int quantity) {
        return Optional.empty();
    }

    @Override
    public Optional<FullShoppingCartDto> deleteProduct(int productId, int shoppingCartId) {
        return Optional.empty();
    }

    private ShoppingCartEntity toEntity(FullShoppingCartDto fullShoppingCartDto) {
        return new ShoppingCartEntity(fullShoppingCartDto.getId(), fullShoppingCartDto.getStatus());
    }

    private FullShoppingCartDto toFullShoppingCartDto(ShoppingCartEntity shoppingCartEntity) {
        return new FullShoppingCartDto(shoppingCartEntity.getProductId(), shoppingCartEntity.getStatus());
    }

    private List<Product> toProducts(List<ProductEntity> entities) {
        return entities.stream().map(productEntity -> productEntity.toProduct()).collect(Collectors.toList());
    }

    private List<ProductEntity> toEntities(List<Product> products) {
        return products.stream().map(product -> product.toEntity()).collect(Collectors.toList());
    }

}
