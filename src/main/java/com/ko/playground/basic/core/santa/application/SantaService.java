package com.ko.playground.basic.core.santa.application;

import com.ko.playground.basic.core.santa.application.input.RegisterSanta;
import com.ko.playground.basic.core.santa.application.input.command.RegisterSantaCommand;
import com.ko.playground.basic.core.santa.application.output.SantaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SantaService implements RegisterSanta {
    private final SantaRepository santaRepository;

    public SantaService(SantaRepository santaRepository) {
        this.santaRepository = santaRepository;
    }

    @Override
    @Transactional
    public void register(RegisterSantaCommand command, PasswordEncoder passwordEncoder) {
        santaRepository.findByEmail(command.email()).ifPresent(santa -> {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        });

        santaRepository.save(command.of(passwordEncoder.encode(command.password())));
    }
}
