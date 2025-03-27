package com.ko.playground.basic.core.productregistration.domain;

import com.ko.playground.basic.support.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity(name = "product_registration")
@AllArgsConstructor
public class ProductRegistration extends BaseEntity {
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Builder.Default
    @Column(name = "is_registered", nullable = false)
    private Boolean isRegistered = false;

    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    @Builder.Default
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public ProductRegistration() {
        this.productId = getProductId();
        this.isRegistered = getIsRegistered();
        this.parentId = getParentId();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

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
