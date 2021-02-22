package com.urjc.shoppingcart.service;

import com.urjc.shoppingcart.controller.dto.ShoppingCartRequestDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ValidatorService {
    private final RestTemplate restTemplate = new RestTemplate();

    public ValidatorService() {
    }

    public boolean validateShoppingCart(ValidateShoppingCart validateShoppingCart) {
        ResponseEntity<Boolean> result;
        result = restTemplate.exchange("http://localhost:8090/validate", HttpMethod.POST, httpEntity(validateShoppingCart), Boolean.class);
        if (result.hasBody()) {
            return result.getBody();
        }
        return false;
    }

    private HttpEntity httpEntity(ValidateShoppingCart validateShoppingCart) {
        return new HttpEntity(validateShoppingCart, new HttpHeaders());
    }

}
