package com.ko.playground.basic.core.product.domain;

import com.ko.playground.basic.support.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "count", nullable = false)
    private Long count = 0L;

    @Column(name = "description")
    private Long description = null;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProductStatus status = ProductStatus.UNREGISTERED;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();


    @Builder
    public static Product create(String name, Long price, Long description, Long count, ProductStatus status) {
        return new Product(
            name,
            price,
            count != null ? count : 0L,
            description,
            status != null ? status : ProductStatus.UNREGISTERED,
            LocalDateTime.now(),
            LocalDateTime.now()
        );
    }
}
