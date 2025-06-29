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
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductRegistration extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "link", nullable = false)
    private String link;

    @Builder.Default
    @Column(name = "is_registered", nullable = false)
    private Boolean isRegistered = false;

    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public static ProductRegistration create(String name, String link, Long parentId) {
        return ProductRegistration.builder()
                .name(name)
                .link(link)
                .parentId(parentId)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public void register() {
        this.isRegistered = true;
        this.updatedAt = LocalDateTime.now();
    }
}
