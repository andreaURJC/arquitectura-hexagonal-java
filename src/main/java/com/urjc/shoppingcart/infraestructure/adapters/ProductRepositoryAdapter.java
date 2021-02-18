package com.urjc.shoppingcart.infraestructure.adapters;

import com.urjc.shoppingcart.domain.dto.NewProductDto;
import com.urjc.shoppingcart.domain.dto.ProductSavedDto;
import com.urjc.shoppingcart.domain.repository.ProductRepository;
import com.urjc.shoppingcart.infraestructure.model.ProductEntity;
import com.urjc.shoppingcart.infraestructure.repository.ProductJpaRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryAdapter implements ProductRepository {

    private ProductJpaRepository productJpaRepository;
    private DozerBeanMapper mapper = new DozerBeanMapper();

    ProductRepositoryAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public ProductSavedDto save(NewProductDto productRequestDto) {
        ProductEntity productEntity = mapper.map(productRequestDto, ProductEntity.class);
        try {
            return mapper.map(this.productJpaRepository.save(productEntity), ProductSavedDto.class);
        } catch (Exception ex){
            throw new IllegalArgumentException(ex);
        }
    }
}
