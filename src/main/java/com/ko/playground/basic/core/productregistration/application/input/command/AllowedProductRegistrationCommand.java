package com.ko.playground.basic.core.productregistration.application.input.command;

public record AllowedProductRegistrationCommand(
        Long santaId,
        Long productRegistrationId
) {
}
