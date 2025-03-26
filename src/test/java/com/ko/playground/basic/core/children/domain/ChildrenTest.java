package com.ko.playground.basic.core.children.domain;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ChildrenTest {
    @Description("성인 여부 확인")
    @Test
    void toCheckAdult() {
        Children adult = Children.builder()
            .name("John")
            .sex(Sex.FEMALE)
            .yearOfBirth(2000L)
            .deliveryZoneId(1L)
            .parentId(1L)
                .build();

        Children children = Children.builder()
                .name("John")
                .sex(Sex.FEMALE)
                .yearOfBirth(2007L)
                .deliveryZoneId(1L)
                .parentId(1L)
                .build();

        assertTrue(adult.checkAdult());
        assertFalse(children.checkAdult());
    }
}