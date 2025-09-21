package com.ko.playground.basic.core.product.domain;

import com.ko.playground.basic.support.UseCaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest extends UseCaseTest {
    @Test
    @DisplayName("상품 생성")
    void create() {
        // given
        String name = "Test Product";
        Long price = 1000L;
        Long count = 10L;
        String description = "description";

        // when
        Product product = Product.create(name, price, description, count);

        // then
        assertEquals(name, product.getName());
        assertEquals(price, product.getPrice());
        assertEquals(count, product.getCount());
        assertEquals(description, product.getDescription());
        assertEquals(ProductStatus.ACTIVE, product.getStatus());
    }

    @Test
    @DisplayName("상품 생성 시 기본값으로 저장")
    void createTest() {
        // given
        String name = "Test Product";
        Long price = 1000L;
        String description = "description";

        // when
        Product product = Product.create(name, price, description, 1L);

        // then
        assertEquals(0, product.getCount());
        assertEquals(ProductStatus.ACTIVE, product.getStatus());
    }
}