package com.ko.playground.basic.api.productregistration.usecase;

import com.ko.playground.basic.api.productregistration.usecase.port.AllowedAndRegistrationProduct;
import com.ko.playground.basic.api.productregistration.usecase.port.AllowedAndRegistrationProductCommand;
import com.ko.playground.basic.core.product.application.input.RegisterProduct;
import com.ko.playground.basic.core.product.application.input.command.RegisterProductCommand;
import com.ko.playground.basic.core.productregistration.application.input.AllowedProductRegistration;
import com.ko.playground.basic.core.productregistration.domain.ProductRegistration;
import com.ko.playground.basic.infrastructure.client.externalshop.adapter.input.SearchProduct;
import com.ko.playground.basic.infrastructure.client.externalshop.adapter.input.SearchProductRequest;
import com.ko.playground.basic.infrastructure.client.externalshop.adapter.input.SearchProductResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductRegistrationAppService implements AllowedAndRegistrationProduct {

    private final AllowedProductRegistration allowedProductRegistration;
    private final SearchProduct searchProduct;
    private final RegisterProduct registerProduct;

    public ProductRegistrationAppService(AllowedProductRegistration allowedProductRegistration, SearchProduct searchProduct, RegisterProduct registerProduct) {
        this.allowedProductRegistration = allowedProductRegistration;
        this.searchProduct = searchProduct;
        this.registerProduct = registerProduct;
    }

    @Override
    public void allowedAndRegistration(AllowedAndRegistrationProductCommand command) {
        ProductRegistration productRegistration = allowedProductRegistration.allowed(command.toAllowedCommand());
        SearchProductRequest request = new SearchProductRequest(productRegistration.getName());
        SearchProductResponse productInfo = searchProduct.search(request);

        if (productInfo.remainingCount() == 0) {
            throw new RuntimeException("상품이 없습니다.");
        }

        RegisterProductCommand registerProductCommand = new RegisterProductCommand(productRegistration.getName(), null, productInfo.price());
        registerProduct.register(registerProductCommand);
    }
}
