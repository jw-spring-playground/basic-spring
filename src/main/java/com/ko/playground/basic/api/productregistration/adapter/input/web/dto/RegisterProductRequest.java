package com.ko.playground.basic.api.productregistration.adapter.input.web.dto;

import com.ko.playground.basic.core.productregistration.application.input.command.RequestProductRegistrationCommand;
import lombok.Getter;

@Getter
public class RegisterProductRequest {
    private String name;
    private String link;

    public RequestProductRegistrationCommand toCommand (
            Long parentId
    ) {
        return new RequestProductRegistrationCommand(
                name, link, parentId
        );
    }
}
