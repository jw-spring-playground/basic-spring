package com.ko.playground.basic.api.productregistration.adapter.input;

import com.ko.playground.basic.api.productregistration.adapter.input.web.dto.RegisterProductRequest;
import com.ko.playground.basic.core.productregistration.application.input.RegisterProductRegistration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductRegistrationApi {
    private final RegisterProductRegistration registerProductRegistration;

    public ProductRegistrationApi(RegisterProductRegistration registerProductRegistration) {
        this.registerProductRegistration = registerProductRegistration;
    }

    @PostMapping("/v1/product/registration")
    ResponseEntity<Void> registerProduct(
          @Validated @RequestBody RegisterProductRequest request
    ) {
        registerProductRegistration.register(request.toCommand(1L));
        return ResponseEntity.status(201).build();
    }
}
