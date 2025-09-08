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
        parentRepository.findByEmail(command.email()).ifPresent(parent -> {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        });

        parentRepository.save(command.of(passwordEncoder.encode(command.password())));
    }
}
