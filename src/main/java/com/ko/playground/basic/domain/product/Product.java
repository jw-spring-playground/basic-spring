package com.ko.playground.basic.domain.product;

import com.ko.playground.basic.support.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Product extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "count", nullable = false)
    private Long count;

    @Column(name = "description")
    private Long description = null;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
}
