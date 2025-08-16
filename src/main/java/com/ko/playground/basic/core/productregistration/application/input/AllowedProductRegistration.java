package com.ko.playground.basic.core.productregistration.application.input;

import com.ko.playground.basic.core.productregistration.application.input.command.AllowedProductRegistrationCommand;

public interface AllowedProductRegistration {
    void allowed(AllowedProductRegistrationCommand command);
}