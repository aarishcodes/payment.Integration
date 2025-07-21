package com.spripe.payment.Integration.controllers;

import com.spripe.payment.Integration.dto.ProductRequest;
import com.spripe.payment.Integration.dto.StripeResponse;
import com.spripe.payment.Integration.services.StripeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/v1")
public class ProductCheckoutController {


    private StripeService stripeService;

    public ProductCheckoutController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<StripeResponse> checkoutProducts(@RequestBody ProductRequest productRequest) {
        StripeResponse stripeResponse = stripeService.productCheckOut(productRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(stripeResponse);
    }
}
