package com.urjc.shoppingcart.infraestructure.adapters;

import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.infraestructure.model.ProductEntity;
import com.urjc.shoppingcart.infraestructure.repository.ProductJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ProductRepositoryAdapterTest {
    @Mock
    private ProductJpaRepository productJpaRepository;

    private ProductRepositoryAdapter productRepositoryAdapter;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.productRepositoryAdapter = new ProductRepositoryAdapter(productJpaRepository);
    }

    @Test
    public void givenExistingFullProductDto_whenSaved_ThenReturnFullProductWithSumOfQuantities() {
        ProductEntity productEntity = new ProductEntity("name", "description", 1);
        FullProductDto newFullProductDto = new FullProductDto("name", "description", 1);
        int finalQuantity = productEntity.getQuantity() + newFullProductDto.getQuantity();
        ProductEntity productEntitySaved = new ProductEntity("name", "description", finalQuantity);

        when(this.productJpaRepository.findProductEntityByName(any())).thenReturn(Optional.of(productEntity));
        when(this.productJpaRepository.save(any())).thenReturn(productEntitySaved);

        Assertions.assertEquals(this.productRepositoryAdapter.save(newFullProductDto).getQuantity(), finalQuantity);
    }

    @Test
    public void givenNewFullProductDto_whenSaved_ThenReturnFullProductDto() {
        FullProductDto newFullProductDto = new FullProductDto("name", "description", 1);
        ProductEntity productEntitySaved = new ProductEntity("name", "description", 1);

        when(this.productJpaRepository.findProductEntityByName(any())).thenReturn(Optional.empty());
        when(this.productJpaRepository.save(any())).thenReturn(productEntitySaved);

        Assertions.assertEquals(this.productRepositoryAdapter.save(newFullProductDto).getQuantity(), 1);
    }

    @Test
    public void givenExistingIdProduct_whenDeleted_ThenShouldReturnDeletedFullProduct() {
        FullProductDto newFullProductDto = new FullProductDto("name", "description", 1);
        ProductEntity productEntity = new ProductEntity("name", "description", 1);

        doNothing().when(this.productJpaRepository).delete(any());

        Assertions.assertEquals(this.productRepositoryAdapter.delete(newFullProductDto).getName(), toFullProductDto(productEntity).getName());
        Assertions.assertEquals(this.productRepositoryAdapter.delete(newFullProductDto).getDescription(), toFullProductDto(productEntity).getDescription());
        Assertions.assertEquals(this.productRepositoryAdapter.delete(newFullProductDto).getQuantity(), toFullProductDto(productEntity).getQuantity());
    }

    private FullProductDto toFullProductDto(ProductEntity entity) {
        return new FullProductDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getQuantity());

    }
}