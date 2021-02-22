package com.urjc.shoppingcart.controller;

import com.urjc.shoppingcart.controller.dto.ShoppingCartResponseDto;
import com.urjc.shoppingcart.controller.exception.InvalidOperationException;
import com.urjc.shoppingcart.controller.exception.ShoppingCartNotFound;
import com.urjc.shoppingcart.domain.dto.FullShoppingCartDto;
import com.urjc.shoppingcart.service.ShoppingCartService;
import com.urjc.shoppingcart.service.ValidateShoppingCart;
import com.urjc.shoppingcart.service.ValidatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingcarts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ValidatorService validatorService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, ValidatorService validatorService) {
        this.shoppingCartService = shoppingCartService;
        this.validatorService = validatorService;
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
    public ResponseEntity<ShoppingCartResponseDto> finish(@PathVariable int id) throws ShoppingCartNotFound, InvalidOperationException {
        FullShoppingCartDto shoppingCart = this.shoppingCartService.finish(id).orElseThrow(ShoppingCartNotFound::new);
        boolean isValid = this.validatorService.validateShoppingCart(new ValidateShoppingCart(id));
        if (isValid) {
        return new ResponseEntity<>(toShoppingCartResponseDto(shoppingCart), HttpStatus.OK);
        } else {
            throw new InvalidOperationException();
        }
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
}
