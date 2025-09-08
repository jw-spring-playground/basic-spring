package com.ko.playground.basic.core.santa.application.input;

import com.ko.playground.basic.core.santa.application.input.command.RegisterSantaCommand;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface RegisterSanta {
    void register(RegisterSantaCommand command, PasswordEncoder passwordEncoder);
}
