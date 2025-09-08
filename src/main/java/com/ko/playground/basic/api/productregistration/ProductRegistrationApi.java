package com.ko.playground.basic.api.productregistration;

import com.ko.playground.basic.api.productregistration.adapter.input.web.dto.AllowedProductRequest;
import com.ko.playground.basic.api.productregistration.adapter.input.web.dto.RegisterProductRequest;
import com.ko.playground.basic.auth.AuthenticatedParent;
import com.ko.playground.basic.auth.AuthenticatedSanta;
import com.ko.playground.basic.core.productregistration.application.input.AllowedProductRegistration;
import com.ko.playground.basic.core.productregistration.application.input.RequestProductRegistration;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class ProductRegistrationApi {
    private final RequestProductRegistration requestProductRegistration;
    private final AllowedProductRegistration allowedProductRegistration;

    @PostMapping("/v1/product/registration")
    ResponseEntity<Void> requestRegisterProduct(
          @Validated @RequestBody RegisterProductRequest request,
          AuthenticatedParent parent
    ) {
        requestProductRegistration.register(request.toCommand(parent.getParentId()));
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/v1/product/registration/allowed")
    ResponseEntity<Void> registerProduct(
            @Validated @RequestBody AllowedProductRequest request,
            AuthenticatedSanta santa
    ) {
        allowedProductRegistration.allowed(request.toCommand(santa.getSantaId()));
        return ResponseEntity.status(201).build();
    }
}
