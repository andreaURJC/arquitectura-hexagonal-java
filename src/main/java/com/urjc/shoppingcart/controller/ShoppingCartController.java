package com.urjc.shoppingcart.controller;

import com.urjc.shoppingcart.controller.dto.ShoppingCartResponseDto;
import com.urjc.shoppingcart.controller.exception.ShoppingCartNotFound;
import com.urjc.shoppingcart.domain.dto.FullShoppingCartDto;
import com.urjc.shoppingcart.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/shoppingcarts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostConstruct
    public void init() {
        populateDatabase();
    }

    @PostMapping()
    public ShoppingCartResponseDto createProduct() {
        FullShoppingCartDto fullShoppingCartDto = this.shoppingCartService.create();
        return toShoppingCartResponseDto(fullShoppingCartDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCartResponseDto> getShoppingCartById(@PathVariable int id) throws ShoppingCartNotFound {
        FullShoppingCartDto shoppingCart = this.shoppingCartService.findById(id).orElseThrow(ShoppingCartNotFound::new);
        return new ResponseEntity<>(toShoppingCartResponseDto(shoppingCart), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShoppingCartResponseDto> deleteShoppingCart(@PathVariable int id) throws ShoppingCartNotFound {
        FullShoppingCartDto shoppingCart = this.shoppingCartService.delete(id).orElseThrow(ShoppingCartNotFound::new);
        return new ResponseEntity<>(toShoppingCartResponseDto(shoppingCart), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ShoppingCartResponseDto> finish(@PathVariable int id) throws ShoppingCartNotFound {
        FullShoppingCartDto shoppingCart = this.shoppingCartService.finish(id).orElseThrow(ShoppingCartNotFound::new);
        return new ResponseEntity<>(toShoppingCartResponseDto(shoppingCart), HttpStatus.OK);
    }

    @PostMapping("/{shoppingCartId}/product/{productId}/quantity/{quantity}")
    public ResponseEntity<ShoppingCartResponseDto> saveProduct(@PathVariable int shoppingCartId, @PathVariable int productId, @PathVariable int quantity) throws ShoppingCartNotFound {
        FullShoppingCartDto fullShoppingCartDto = this.shoppingCartService.saveProduct(productId, shoppingCartId, quantity).orElseThrow(ShoppingCartNotFound::new);
        return new ResponseEntity<>(toShoppingCartResponseDto(fullShoppingCartDto), HttpStatus.OK);
    }

    @DeleteMapping("/{shoppingCartId}/product/{productId}")
    public ResponseEntity<ShoppingCartResponseDto> saveProduct(@PathVariable int shoppingCartId, @PathVariable int productId) throws ShoppingCartNotFound {
        FullShoppingCartDto fullShoppingCartDto = this.shoppingCartService.deleteProduct(productId, shoppingCartId).orElseThrow(ShoppingCartNotFound::new);
        return new ResponseEntity<>(toShoppingCartResponseDto(fullShoppingCartDto), HttpStatus.OK);
    }

    private ShoppingCartResponseDto toShoppingCartResponseDto(FullShoppingCartDto fullShoppingCartDto) {
        return new ShoppingCartResponseDto(fullShoppingCartDto.getId(), fullShoppingCartDto.getProducts(), fullShoppingCartDto.getStatus());
    }

    private void populateDatabase() {
        this.shoppingCartService.create();
        this.shoppingCartService.create();
    }
}
