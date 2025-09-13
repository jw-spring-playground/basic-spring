package com.ko.playground.basic.api.productregistration.usecase.port;

import com.ko.playground.basic.core.productregistration.application.input.command.AllowedProductRegistrationCommand;

public record AllowedAndRegistrationProductCommand(
        Long santaId,
        Long productRegistrationId
) {
    public AllowedProductRegistrationCommand toAllowedCommand() {
        return new AllowedProductRegistrationCommand(santaId, productRegistrationId);
    }
}
