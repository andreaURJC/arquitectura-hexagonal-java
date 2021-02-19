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

@RunWith(MockitoJUnitRunner.class)
class ProductUseCaseImplTest {
    @Mock
    private ProductRepository productRepository;

    private ProductUseCase productUseCase;

    ProductDto productDto;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.productUseCase = new ProductUseCaseImpl(productRepository);
        this.productDto = new ProductDto("name", "description", 1);
    }

    @Test
    void givenProductDto_whenSaved_thenReturnFullSavedProductWithTheSameData() {
        ProductDto productDto = new ProductDto("name", "description", 1);
        FullProductDto fullProduct = toFullBookDto(productDto);

        Mockito.when(productRepository.save(Mockito.any())).thenReturn(fullProduct);
        FullProductDto fullProductDtoSaved = productUseCase.save(productDto);

        Assertions.assertEquals(fullProductDtoSaved.getName(), fullProduct.getName());
        Assertions.assertEquals(fullProductDtoSaved.getDescription(), fullProduct.getDescription());
    }

    @Test
    void givenProductDto_whenDelete_thenReturnFullSavedProductWithTheSameData() {
        Optional<FullProductDto> fullProduct = Optional.of(toFullBookDto(productDto));

        Mockito.when(productRepository.delete(1)).thenReturn(fullProduct);
        Optional<FullProductDto> fullProductDtoDeleted = productUseCase.delete(1);

        Assertions.assertEquals(fullProductDtoDeleted.get().getName(), fullProduct.get().getName());
        Assertions.assertEquals(fullProductDtoDeleted.get().getDescription(), fullProduct.get().getDescription());
    }

    private FullProductDto toFullBookDto(ProductDto productDto) {
        return new FullProductDto(productDto.getName(), productDto.getDescription(), productDto.getQuantity());
    }
}