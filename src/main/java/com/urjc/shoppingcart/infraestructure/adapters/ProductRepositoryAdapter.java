package com.urjc.shoppingcart.infraestructure.adapters;

import com.urjc.shoppingcart.domain.DTO.NewProductDto;
import com.urjc.shoppingcart.domain.repository.ProductRepository;
import com.urjc.shoppingcart.infraestructure.model.ProductEntity;
import com.urjc.shoppingcart.infraestructure.repository.ProductJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryAdapter implements ProductRepository {

    private ProductJpaRepository productJpaRepository;

    ProductRepositoryAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public void save(NewProductDto productRequestDto) {
        ProductEntity productEntity = new ProductEntity(
                productRequestDto.getName(),
                productRequestDto.getDescripcion(),
                productRequestDto.getQuantity());
        this.productJpaRepository.save(productEntity);
    }
}
