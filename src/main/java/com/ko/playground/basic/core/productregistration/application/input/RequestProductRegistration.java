package com.ko.playground.basic.core.productregistration.application.input;

import com.ko.playground.basic.core.productregistration.application.input.command.RequestProductRegistrationCommand;

public interface RequestProductRegistration {
    void register(RequestProductRegistrationCommand command);
}
