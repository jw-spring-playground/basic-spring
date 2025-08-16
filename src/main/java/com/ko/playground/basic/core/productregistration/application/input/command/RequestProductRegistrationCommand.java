package com.ko.playground.basic.core.productregistration.application.input.command;

import com.ko.playground.basic.core.productregistration.domain.ProductRegistration;

public record RequestProductRegistrationCommand(
        String name,
        String link,
        Long parentId
) {
    public ProductRegistration of() {
        return ProductRegistration.create(name, link, parentId);
    }
}
