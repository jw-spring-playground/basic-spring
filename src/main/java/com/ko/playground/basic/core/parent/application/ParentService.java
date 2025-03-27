package com.ko.playground.basic.core.parent.application;

import com.ko.playground.basic.core.parent.application.input.RegisterParent;
import com.ko.playground.basic.core.parent.application.input.command.RegisterParentCommand;
import com.ko.playground.basic.core.parent.application.output.ParentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ParentService implements RegisterParent {
    private final ParentRepository parentRepository;
    PasswordEncoder passwordEncoder;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public void register(RegisterParentCommand command) {
        parentRepository.save(command.of(passwordEncoder.encode(command.password())));
    }
}
