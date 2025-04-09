package com.ko.playground.basic.core.parent.application.input;

import com.ko.playground.basic.core.parent.application.input.command.RegisterParentCommand;
import com.ko.playground.basic.core.parent.application.output.ParentRepository;
import com.ko.playground.basic.core.parent.domain.Parent;
import com.ko.playground.basic.support.UseCaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RegisterParentTest extends UseCaseTest {
    public final RegisterParent registerParent;
    public final ParentRepository parentRepository;
    public final PasswordEncoder passwordEncoder;

    RegisterParentTest(RegisterParent registerParent, ParentRepository parentRepository) {
        this.registerParent = registerParent;
        this.parentRepository = parentRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    @DisplayName("부모 등록 성공적으로 실행")
    void register() {
        // Given
        RegisterParentCommand command = new RegisterParentCommand("email", "password");

        // When
        registerParent.register(command, passwordEncoder);

        // Then
        assertDoesNotThrow(() -> {
            Parent parent = parentRepository.findByEmail(command.email()).orElseThrow();
            assertEquals(command.email(), parent.getEmail());
        });
    }
}