package com.ko.playground.basic.core.children.domain;

import com.ko.playground.basic.support.UseCaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChildrenTest extends UseCaseTest {
    @Description("성인 여부 확인")
    @Test
    void toCheckAdult() {
        Children adult = Children.create("John", Sex.FEMALE, 2000L, "주소", 1L);
        Children children = Children.create("John", Sex.FEMALE, 2007L, "주소", 1L);

        assertTrue(adult.checkAdult());
        assertFalse(children.checkAdult());
    }
}