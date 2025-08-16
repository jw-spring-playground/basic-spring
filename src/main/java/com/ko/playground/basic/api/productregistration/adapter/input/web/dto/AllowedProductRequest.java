package com.ko.playground.basic.api.productregistration.adapter.input.web.dto;

import com.ko.playground.basic.core.productregistration.application.input.command.AllowedProductRegistrationCommand;
import lombok.Data;

@Data
public class AllowedProductRequest {
    private Long id;

    public AllowedProductRegistrationCommand toCommand(Long santaId) {
        return new AllowedProductRegistrationCommand(santaId, id);
    }
}
