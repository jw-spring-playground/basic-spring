package com.ko.playground.basic.api.productregistration.adapter.input.web.dto;

import com.ko.playground.basic.api.productregistration.usecase.port.AllowedAndRegistrationProductCommand;
import lombok.Data;

@Data
public class AllowedProductRequest {
    private Long id;

    public AllowedAndRegistrationProductCommand toCommand(Long santaId) {
        return new AllowedAndRegistrationProductCommand(santaId, id);
    }
}
