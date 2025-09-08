package com.ko.playground.basic.api.santa.adapter.input.web.dto;

import com.ko.playground.basic.core.santa.application.input.command.RegisterSantaCommand;
import lombok.Data;

@Data
public class RegisterSantaRequest {
    private String email;
    private String password;

    public RegisterSantaCommand toCommand() {
        return new RegisterSantaCommand(email, password);
    }
}
