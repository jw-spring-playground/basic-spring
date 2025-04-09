package com.ko.playground.basic.core.parent.application;

import com.ko.playground.basic.core.parent.application.input.RegisterParent;
import com.ko.playground.basic.core.parent.application.input.command.RegisterParentCommand;
import com.ko.playground.basic.core.parent.application.output.ParentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParentService implements RegisterParent {
    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    @Transactional
    public void register(RegisterParentCommand command, PasswordEncoder passwordEncoder) {
        parentRepository.save(command.of(passwordEncoder.encode(command.password())));
    }
}
