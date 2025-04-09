package com.ko.playground.basic.core.parent.domain;

import com.ko.playground.basic.support.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @NoArgsConstructor(access = AccessLevel.PROTECTED)를 쓰는 이유
 * 아무런 값도 갖지 않는 의미 없는 객체의 생성을 막기 위해 사용
 **/
@Getter
@Entity
@Table(name = "parent")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Parent extends BaseEntity {
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "encrypted_password", nullable = false)
    private String encryptedPassword;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Builder
    public static Parent create(String email, String encryptedPassword) {
        return new Parent(email, encryptedPassword, LocalDateTime.now(), LocalDateTime.now());
    }

    void verifyPassword(PasswordEncoder passwordEncoder, String password) {
        if (!passwordEncoder.matches(password, encryptedPassword)) {
            throw new IllegalArgumentException("Password is not correct");
        };
    }
}
