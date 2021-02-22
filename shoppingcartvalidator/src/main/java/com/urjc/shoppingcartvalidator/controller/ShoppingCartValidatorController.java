package com.urjc.shoppingcartvalidator.controller;

import com.urjc.shoppingcartvalidator.domain.ValidatorException;
import com.urjc.shoppingcartvalidator.service.ShoppingCartValidatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/validate")
public class ShoppingCartValidatorController {
    private final ShoppingCartValidatorService shoppingCartValidatorService;

    public ShoppingCartValidatorController(ShoppingCartValidatorService shoppingCartValidatorService) {
        this.shoppingCartValidatorService = shoppingCartValidatorService;
    }

    @PostMapping()
    public ResponseEntity<Boolean> validate(@RequestBody ShoppingCartRequestDto shoppingCartRequestDto) throws ValidatorException {
        boolean result = this.shoppingCartValidatorService.validateShoppingCart(shoppingCartRequestDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler({ValidatorException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity validatorExceptionHandler() {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
