package com.ko.playground.basic.core.product.domain;

public enum ProductStatus {
    ACTIVE("활성"),
    INACTIVE("비활성"),
    DELETED("삭제");

    private final String description;

    ProductStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
