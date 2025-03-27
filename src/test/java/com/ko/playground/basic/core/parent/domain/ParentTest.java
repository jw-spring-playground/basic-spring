package com.ko.playground.basic.core.parent.domain;

import com.ko.playground.basic.support.UseCaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParentTest extends UseCaseTest {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ParentTest(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Test
    public void verifyTest() {
        String password = "password";
        String wrongPassword = "wrongPassword";
        String email = "email";
        String encodedPassword = passwordEncoder.encode(password);
        String wrongEncodedPassword = passwordEncoder.encode(wrongPassword);

        Parent parent = Parent.builder()
                .email(email)
                .encryptedPassword(encodedPassword)
                .build();

        assertThrows(IllegalArgumentException.class, () -> parent.verifyPassword(passwordEncoder, wrongEncodedPassword));

        assertThatCode(() -> parent.verifyPassword(passwordEncoder, password)).doesNotThrowAnyException();
    }
}
