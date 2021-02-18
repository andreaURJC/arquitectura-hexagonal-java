package com.urjc.shoppingcart.infraestructure.adapters;

import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.repository.ProductRepository;
import com.urjc.shoppingcart.infraestructure.model.ProductEntity;
import com.urjc.shoppingcart.infraestructure.repository.ProductJpaRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
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
        ProductEntity productEntity = toEntity(fullProductDto);
        Optional<ProductEntity> maybeExists = this.productJpaRepository.findProductEntityByName(productEntity.getName());

        if (maybeExists.isPresent()) {
            ProductEntity product = maybeExists.get();
            product.setQuantity(fullProductDto.getQuantity() + product.getQuantity());
            return toFullProductDto(this.productJpaRepository.save(product));
        } else {
            return toFullProductDto(this.productJpaRepository.save(productEntity));
        }
    }

    @Override
    public List<FullProductDto> findAll() {
        List<ProductEntity> maybeProducts = this.productJpaRepository.findAll();
        return maybeProducts.stream().map(this::toFullProductDto).collect(Collectors.toList());
    }

    @Override
    public Optional<FullProductDto> findById(int id) {
        Optional<ProductEntity> maybeProduct = this.productJpaRepository.findById(id);
        return maybeProduct.map(this::toFullProductDto);
    }

    @Override
    public Optional<FullProductDto> delete(int id) {
        Optional<ProductEntity> maybeProduct = this.productJpaRepository.findById(id);
        if (maybeProduct.isPresent()) {
            this.productJpaRepository.delete(maybeProduct.get());
        }

        return maybeProduct.map(this::toFullProductDto);
    }

    private ProductEntity toEntity(FullProductDto fullProductDto) {
        return mapper.map(fullProductDto, ProductEntity.class);
    }

    private FullProductDto toFullProductDto(ProductEntity entity) {
        return mapper.map(entity, FullProductDto.class);
    }
}
