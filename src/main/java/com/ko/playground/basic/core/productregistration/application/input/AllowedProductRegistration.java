package com.ko.playground.basic.core.productregistration.application.input;

import com.ko.playground.basic.core.productregistration.application.input.command.AllowedProductRegistrationCommand;
import com.ko.playground.basic.core.productregistration.domain.ProductRegistration;

public interface AllowedProductRegistration {
    ProductRegistration allowed(AllowedProductRegistrationCommand command);
}