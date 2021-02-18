package com.urjc.shoppingcart.controller;

import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.dto.ProductRequestDto;
import com.urjc.shoppingcart.service.ProductService;
import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    private DozerBeanMapper mapper = new DozerBeanMapper();

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ProductResponseDto createProduct(
            @RequestBody ProductRequestDto productRequestDto) {
        FullProductDto productCreated = this.productService.createProduct(productRequestDto);
        return toProductResponseDto(productCreated);
    }

    @GetMapping()
    public List<ProductResponseDto> getAllProducts() {
        List<FullProductDto> allProducts = this.productService.getAllProducts();
        return allProducts.stream().map(this::toProductResponseDto).collect(Collectors.toList());
    }

    public ProductResponseDto toProductResponseDto(FullProductDto fullProductDto) {
        return mapper.map(fullProductDto, ProductResponseDto.class);
    }
}
