package com.ko.playground.basic.core.parent.application.input;

import com.ko.playground.basic.core.parent.application.input.command.RegisterParentCommand;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface RegisterParent {
    void register(RegisterParentCommand command, PasswordEncoder passwordEncoder);
}
