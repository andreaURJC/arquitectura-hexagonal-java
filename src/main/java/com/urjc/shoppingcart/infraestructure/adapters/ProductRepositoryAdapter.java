package com.urjc.shoppingcart.infraestructure.adapters;

import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.repository.ProductRepository;
import com.urjc.shoppingcart.infraestructure.model.ProductEntity;
import com.urjc.shoppingcart.infraestructure.repository.ProductJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryAdapter implements ProductRepository {

    private ProductJpaRepository productJpaRepository;

    ProductRepositoryAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public FullProductDto save(FullProductDto fullProductDto) {
        return toFullProductDto(this.productJpaRepository.save(toEntity(fullProductDto)));
    }

    @Override
    public List<FullProductDto> findAll() {
        List<ProductEntity> products = this.productJpaRepository.findAll();
        return products.stream().map(this::toFullProductDto).collect(Collectors.toList());
    }

    @Override
    public Optional<FullProductDto> findById(int id) {
        Optional<ProductEntity> product = this.productJpaRepository.findById(id);
        return product.map(this::toFullProductDto);
    }

    @Override
    public FullProductDto delete(FullProductDto productDto) {
        this.productJpaRepository.delete(toEntity(productDto));
        return productDto;
    }

    @Override
    public Optional<FullProductDto> findProductEntityByName(String name) {
        Optional<ProductEntity> product = this.productJpaRepository.findProductEntityByName(name);
        return product.map(this::toFullProductDto);
    }

    private ProductEntity toEntity(FullProductDto fullProductDto) {
        return new ProductEntity(fullProductDto.getId(), fullProductDto.getName(), fullProductDto.getDescription());
    }


    private FullProductDto toFullProductDto(ProductEntity entity) {
        return new FullProductDto(entity.getId(), entity.getName(), entity.getDescription());
    }
}
