package com.ko.playground.basic.core.productregistration.domain;

import com.ko.playground.basic.support.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "product_registration")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductRegistration extends BaseEntity {
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "is_registered", nullable = false)
    private Boolean isRegistered = false;

    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Builder
    public static ProductRegistration create(Long productId, Long parentId) {
        return ProductRegistration.builder()
            .productId(productId)
            .parentId(parentId)
            .build();
    }

    public void register() {
        this.isRegistered = true;
        this.updatedAt = LocalDateTime.now();
    }
}
