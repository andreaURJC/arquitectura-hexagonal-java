package com.urjc.shoppingcart.application.controller;

import com.urjc.shoppingcart.domain.DTO.ProductRequestDto;
import com.urjc.shoppingcart.domain.usecases.ProductUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @PostMapping()
    public void createBook(
            @RequestBody ProductRequestDto productRequestDto) {
        ProductRequestDto product = new ProductRequestDto(productRequestDto.getName(),productRequestDto.getDescripcion(),productRequestDto.getQuantity());
        this.productUseCase.save(productRequestDto);
    }
}
