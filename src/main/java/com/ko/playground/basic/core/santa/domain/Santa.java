package com.ko.playground.basic.core.santa.domain;

import com.ko.playground.basic.support.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity(name = "santa")
public class Santa extends BaseEntity {
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "encrypted_password", nullable = false)
    private String encryptedPassword;

    @Column(name = "delivery_zone_id")
    private Long deliveryZoneId = null;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Santa() {
        this.email = getEmail();
        this.encryptedPassword = getEncryptedPassword();
        this.deliveryZoneId = getDeliveryZoneId();
        createdAt = getCreatedAt();
        updatedAt = getUpdatedAt();
    }

    public Santa(String email, String encryptedPassword) {
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
}
