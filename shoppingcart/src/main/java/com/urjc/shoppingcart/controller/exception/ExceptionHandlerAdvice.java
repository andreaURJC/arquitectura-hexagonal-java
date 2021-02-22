package com.urjc.shoppingcart.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler({ProductNotFoundException.class, ShoppingCartNotFound.class})
    public ResponseEntity handleException(ProductNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler({InvalidOperationException.class})
    public ResponseEntity invalidOperationExceptionHandler(InvalidOperationException e) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Cannot finish this shopping cart, there are some product that are not available.");
    }
}
