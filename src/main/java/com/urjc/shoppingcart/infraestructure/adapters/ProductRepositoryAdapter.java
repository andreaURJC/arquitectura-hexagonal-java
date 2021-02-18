package com.urjc.shoppingcart.infraestructure.adapters;

import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.repository.ProductRepository;
import com.urjc.shoppingcart.infraestructure.model.ProductEntity;
import com.urjc.shoppingcart.infraestructure.repository.ProductJpaRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryAdapter implements ProductRepository {

    private ProductJpaRepository productJpaRepository;
    private DozerBeanMapper mapper = new DozerBeanMapper();

    ProductRepositoryAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public FullProductDto save(FullProductDto fullProductDto) {
        ProductEntity productSavedEntity = this.productJpaRepository.save(toEntity(fullProductDto));
        return toFullProductDto(productSavedEntity);
    }

    @Override
    public List<FullProductDto> findAll() {
        List<ProductEntity> maybeProducts = this.productJpaRepository.findAll();
        return maybeProducts.stream().map(this::toFullProductDto).collect(Collectors.toList());
    }

    private ProductEntity toEntity(FullProductDto fullProductDto) {
        return mapper.map(fullProductDto, ProductEntity.class);
    }

    private FullProductDto toFullProductDto(ProductEntity entity) {
        return mapper.map(entity, FullProductDto.class);
    }
}
