package com.ko.playground.basic.core.children.domain;

import com.ko.playground.basic.support.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@AllArgsConstructor
public class Children extends BaseEntity {
    @Column(name = "name", nullable = false)
    String name;

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

    public Children() {
        this.name = getName();
        this.sex = getSex();
        this.yearOfBirth = getYearOfBirth();
        this.deliveryZoneId = getDeliveryZoneId();
        this.parentId = getParentId();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public static Children create(String name, Sex sex, Long yearOfBirth, Long deliveryZoneId, Long parentId) {
        return Children.builder()
            .name(name)
            .sex(sex)
            .yearOfBirth(yearOfBirth)
            .deliveryZoneId(deliveryZoneId)
            .parentId(parentId)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();
    }

    public boolean checkAdult() {
        return yearOfBirth <= LocalDateTime.now().getYear() - 20;
    }

    public Long changeDeliveryZone(Long deliveryZoneId) {
        this.deliveryZoneId = deliveryZoneId;
        return this.getId();
    }
}
