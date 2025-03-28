package com.ko.playground.basic.core.children.domain;

import com.ko.playground.basic.support.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "children")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Children extends BaseEntity {
    @Column(name = "name", nullable = false)
    String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false)
    private Sex sex;

    @Column(name = "year_of_birth", nullable = false)
    private Long yearOfBirth;

    @Column(name = "delivery_zone_id")
    private Long deliveryZoneId = null;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Builder
    public static Children create(String name, Sex sex, Long yearOfBirth, Long deliveryZoneId, Long parentId) {
        return new Children(name, sex, yearOfBirth, deliveryZoneId, parentId, LocalDateTime.now(), LocalDateTime.now());
    }

    public boolean checkAdult() {
        return yearOfBirth <= LocalDateTime.now().getYear() - 20;
    }

    public Long changeDeliveryZone(Long deliveryZoneId) {
        this.deliveryZoneId = deliveryZoneId;
        return this.getId();
    }
}
