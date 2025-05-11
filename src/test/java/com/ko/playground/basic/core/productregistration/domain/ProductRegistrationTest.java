package com.ko.playground.basic.core.productregistration.domain;

import com.ko.playground.basic.support.UseCaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRegistrationTest extends UseCaseTest {
    @Test
    @DisplayName("상품 등록 생성")
    void register() {
        // given
        String name = "Test Product Registration";
        String link = "http://example.com";
        Long parentId = 1L;

        // when
        ProductRegistration productRegistration = ProductRegistration.create(name, link, parentId);

        // then
        assertEquals(name, productRegistration.getName());
        assertEquals(link, productRegistration.getLink());
        assertEquals(parentId, productRegistration.getParentId());
    }

    @Test
    @DisplayName("상품 등록 생성 시 기본값 저장")
    void defaultRegister() {
        // given
        String name = "Test Product Registration";
        String link = "http://example.com";
        Long parentId = 1L;

        // when
        ProductRegistration productRegistration = ProductRegistration.create(name, link, parentId);

        // then
        assertFalse(productRegistration.getIsRegistered());
    }
}