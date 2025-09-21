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

    private String address;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Builder
    public static Children create(String name, Sex sex, Long yearOfBirth, String address, Long parentId) {
        return new Children(name, sex, yearOfBirth, address, parentId, LocalDateTime.now(), LocalDateTime.now());
    }

    public boolean checkAdult() {
        return yearOfBirth <= LocalDateTime.now().getYear() - 20;
    }
}
