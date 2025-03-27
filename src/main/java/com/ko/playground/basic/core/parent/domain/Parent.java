package com.ko.playground.basic.core.parent.domain;

import com.ko.playground.basic.support.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@Builder
@Entity(name = "parent")
@AllArgsConstructor
public class Parent extends BaseEntity {
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "encrypted_password", nullable = false)
    private String encryptedPassword;

    @Builder.Default
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Parent() {
        this.email = getEmail();
        this.encryptedPassword = getEncryptedPassword();
        this.createdAt = getCreatedAt();
        this.updatedAt = getUpdatedAt();
    }

    public static Parent create(String email, String encryptedPassword) {
        return Parent.builder()
                .email(email)
                .encryptedPassword(encryptedPassword)
                .build();
    }

    void verifyPassword(PasswordEncoder passwordEncoder, String password) {
        if (!passwordEncoder.matches(password, encryptedPassword)) {
            throw new IllegalArgumentException("Password is not correct");
        };
    }
}
