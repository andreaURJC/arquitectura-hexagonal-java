package com.urjc.shoppingcart.controller;

import com.urjc.shoppingcart.controller.dto.ProductResponseDto;
import com.urjc.shoppingcart.controller.exception.ProductNotFoundException;
import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.dto.ProductRequestDto;
import com.urjc.shoppingcart.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

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
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<FullProductDto> allProducts = this.productService.getAllProducts();
        return new ResponseEntity<>(allProducts.stream().map(this::toProductResponseDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable int id) throws ProductNotFoundException {
        FullProductDto product = this.productService.findById(id).orElseThrow(ProductNotFoundException::new);
        return new ResponseEntity<>(toProductResponseDto(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDto> deleteProductById(@PathVariable int id) throws ProductNotFoundException {
        FullProductDto product = this.productService.delete(id).orElseThrow(ProductNotFoundException::new);
        return new ResponseEntity<>(toProductResponseDto(product), HttpStatus.OK);
    }

    public ProductResponseDto toProductResponseDto(FullProductDto fullProductDto) {
        return new ProductResponseDto(fullProductDto.getId(), fullProductDto.getName(), fullProductDto.getDescription());
    }
}
