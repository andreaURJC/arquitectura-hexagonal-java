package com.urjc.shoppingcart.domain.usecases;

import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.dto.ProductDto;
import com.urjc.shoppingcart.domain.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ProductUseCaseImplTest {
    @Mock
    private ProductRepository productRepository;

    private ProductUseCase productUseCase;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.productUseCase = new ProductUseCaseImpl(productRepository);
    }

    @Test
    void givenExistingProductDto_whenSaved_thenReturnFullSavedProductWithUpdatedDescription() {
        FullProductDto foundProduct = new FullProductDto(1, "name", "description");
        ProductDto newProductDto = new ProductDto("name", "description nueva");
        FullProductDto productEntitySaved = new FullProductDto(1, "name", newProductDto.getDescription());

        when(this.productRepository.findProductEntityByName(any())).thenReturn(Optional.of(foundProduct));
        when(this.productRepository.save(any())).thenReturn(productEntitySaved);

        FullProductDto response = this.productUseCase.save(newProductDto);
        Assertions.assertEquals(response.getDescription(), foundProduct.getDescription());
    }

    @Test
    void givenNewProductDto_whenSaved_thenReturnFullSavedProductWithTheSameData() {
        ProductDto newProductDto = new ProductDto("name", "description");
        FullProductDto productEntitySaved = new FullProductDto(1, "name", "description");

        when(this.productRepository.findProductEntityByName(any())).thenReturn(Optional.empty());
        when(this.productRepository.save(any())).thenReturn(productEntitySaved);

        Assertions.assertEquals(this.productUseCase.save(newProductDto).getName(), newProductDto.getName());
    }

    @Test
    void givenProductDto_whenDelete_thenReturnFullProduct() {
        FullProductDto fullProductDto = new FullProductDto(1, "name", "description");

        Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(fullProductDto));
        Mockito.when(productRepository.delete(any())).thenReturn(fullProductDto);
        FullProductDto fullProductDtoDeleted = productUseCase.delete(1).get();

        Assertions.assertEquals(fullProductDtoDeleted.getName(), fullProductDto.getName());
        Assertions.assertEquals(fullProductDtoDeleted.getDescription(), fullProductDto.getDescription());
    }

    @Test
    void givenNotExistingProductDto_whenDelete_thenReturnNoProduct() {
        Mockito.when(productRepository.findById(1)).thenReturn(Optional.empty());
        Optional<FullProductDto> fullProductDtoDeleted = productUseCase.delete(1);

        Assertions.assertEquals(fullProductDtoDeleted, Optional.empty());
    }
}