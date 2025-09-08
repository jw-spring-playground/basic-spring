package com.ko.playground.basic.api.parent.input.web.dto;

import com.ko.playground.basic.core.parent.application.input.command.RegisterParentCommand;
import lombok.Data;

@Data
public class RegisterParentRequest {
    private String email;
    private String password;

    public RegisterParentCommand toCommand() {
        return new RegisterParentCommand(email, password);
    }
}
