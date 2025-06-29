package com.ko.playground.basic.api.productregistration.adapter.input.web.dto;

import com.ko.playground.basic.core.productregistration.application.input.command.RegisterProductRegistrationCommand;
import lombok.Getter;

@Getter
public class RegisterProductRequest {
    private String name;
    private String link;

    public RegisterProductRegistrationCommand toCommand (
            Long parentId
    ) {
        return new RegisterProductRegistrationCommand(
                name, link, parentId
        );
    }
}
