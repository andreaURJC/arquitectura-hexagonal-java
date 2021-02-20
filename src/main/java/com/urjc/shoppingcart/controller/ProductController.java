package com.urjc.shoppingcart.controller;

import com.urjc.shoppingcart.controller.dto.ProductResponseDto;
import com.urjc.shoppingcart.controller.exception.ProductNotFoundException;
import com.urjc.shoppingcart.domain.dto.FullProductDto;
import com.urjc.shoppingcart.domain.dto.ProductRequestDto;
import com.urjc.shoppingcart.service.ProductService;
import org.dozer.DozerBeanMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void init() {
        populateDatabase();
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

    public void populateDatabase() {
        ProductRequestDto productRequestDto1 = new ProductRequestDto("Alexa", "Alexa es el servicio de voz ubicado en la nube de Amazon disponible en los dispositivos de Amazon");
        ProductRequestDto productRequestDto2 = new ProductRequestDto("Conga", "Conga el Robot Aspirador que Friega y Diseño Español. 2 años de garantía");
        ProductRequestDto productRequestDto3 = new ProductRequestDto("Chromecast", "Google Chrome es un navegador web de código cerrado desarrollado por Google, aunque derivado de proyectos de código abierto.");

        this.productService.createProduct(productRequestDto1);
        this.productService.createProduct(productRequestDto2);
        this.productService.createProduct(productRequestDto3);
    }
}
