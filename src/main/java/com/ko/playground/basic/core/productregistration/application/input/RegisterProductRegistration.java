package com.ko.playground.basic.core.productregistration.application.input;

import com.ko.playground.basic.core.productregistration.application.input.command.RegisterProductRegistrationCommand;

public interface RegisterProductRegistration {
    void register(RegisterProductRegistrationCommand command);
}
