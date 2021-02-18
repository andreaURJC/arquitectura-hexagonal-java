package com.urjc.shoppingcart.application.controller;

import com.urjc.shoppingcart.domain.dto.ProductRequestDto;
import com.urjc.shoppingcart.domain.dto.ProductResponseDto;
import com.urjc.shoppingcart.domain.usecases.ProductUseCase;
import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductUseCase productUseCase;

    private DozerBeanMapper mapper = new DozerBeanMapper();

    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @PostMapping()
    public ProductResponseDto createProduct(
            @RequestBody ProductRequestDto productRequestDto) {
        return this.productUseCase.save(productRequestDto);
    }
}
