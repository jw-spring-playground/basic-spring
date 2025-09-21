package com.ko.playground.basic.core.delivery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {

    // =================== 성공 케이스 ===================

    @Test
    @DisplayName("객체 생성 시 초기 상태는 PREPARING 이다")
    void init() {
        Delivery delivery = new Delivery(1L, 1L);
        assertEquals(DeliveryStatus.PREPARING, delivery.getStatus());
    }

    @Test
    @DisplayName("PREPARING -> READY_FOR_DISPATCH 상태 변경에 성공한다")
    void readyForDispatch_Success() {
        Delivery delivery = new Delivery(1L, 1L);
        delivery.readyForDispatch();
        assertEquals(DeliveryStatus.READY_FOR_DISPATCH, delivery.getStatus());
    }

    @Test
    @DisplayName("READY_FOR_DISPATCH -> IN_TRANSIT 상태 변경에 성공한다")
    void startTransit_Success() {
        Delivery delivery = new Delivery(1L, 1L, DeliveryStatus.READY_FOR_DISPATCH);
        delivery.startTransit(100L);
        assertEquals(DeliveryStatus.IN_TRANSIT, delivery.getStatus());
        assertEquals(100L, delivery.getSantaId());
    }

    @Test
    @DisplayName("IN_TRANSIT -> DELIVERED 상태 변경에 성공한다")
    void complete_Success() {
        Delivery delivery = new Delivery(1L, 1L, DeliveryStatus.IN_TRANSIT);
        delivery.complete();
        assertEquals(DeliveryStatus.DELIVERED, delivery.getStatus());
    }

    @Test
    @DisplayName("DELIVERED -> IN_TRANSIT 상태로 되돌리기에 성공한다 (실수 정정)")
    void revertToInTransit_Success() {
        Delivery delivery = new Delivery(1L, 1L, DeliveryStatus.DELIVERED);
        delivery.revertToInTransit();
        assertEquals(DeliveryStatus.IN_TRANSIT, delivery.getStatus());
    }

    @Test
    @DisplayName("IN_TRANSIT 상태에서 FAILED 상태로 변경에 성공한다")
    void fail_Success() {
        Delivery delivery = new Delivery(1L, 1L, DeliveryStatus.IN_TRANSIT);
        delivery.fail();
        assertEquals(DeliveryStatus.FAILED, delivery.getStatus());
    }

    @Test
    @DisplayName("PREPARING 상태에서 CANCELED 상태로 변경에 성공한다")
    void cancel_Success() {
        Delivery delivery = new Delivery(1L, 1L, DeliveryStatus.PREPARING);
        delivery.cancel();
        assertEquals(DeliveryStatus.CANCELED, delivery.getStatus());
    }

    // =================== 실패 케이스 (Parameterized) ===================

    @ParameterizedTest
    @EnumSource(value = DeliveryStatus.class, names = {"PREPARING"}, mode = EnumSource.Mode.EXCLUDE)
    @DisplayName("PREPARING 상태가 아닐 때 READY_FOR_DISPATCH로 변경하려고 하면 실패한다")
    void readyForDispatch_Fail(DeliveryStatus status) {
        Delivery delivery = new Delivery(1L, 1L, status);
        assertThrows(IllegalStateException.class, delivery::readyForDispatch);
    }

    @ParameterizedTest
    @EnumSource(value = DeliveryStatus.class, names = {"READY_FOR_DISPATCH"}, mode = EnumSource.Mode.EXCLUDE)
    @DisplayName("READY_FOR_DISPATCH 상태가 아닐 때 IN_TRANSIT으로 변경하려고 하면 실패한다")
    void startTransit_Fail(DeliveryStatus status) {
        Delivery delivery = new Delivery(1L, 1L, status);
        assertThrows(IllegalStateException.class, () -> delivery.startTransit(100L));
    }

    @ParameterizedTest
    @EnumSource(value = DeliveryStatus.class, names = {"IN_TRANSIT"}, mode = EnumSource.Mode.EXCLUDE)
    @DisplayName("IN_TRANSIT 상태가 아닐 때 DELIVERED로 변경하려고 하면 실패한다")
    void complete_Fail(DeliveryStatus status) {
        Delivery delivery = new Delivery(1L, 1L, status);
        assertThrows(IllegalStateException.class, delivery::complete);
    }

    @ParameterizedTest
    @EnumSource(value = DeliveryStatus.class, names = {"DELIVERED"}, mode = EnumSource.Mode.EXCLUDE)
    @DisplayName("DELIVERED 상태가 아닐 때 IN_TRANSIT으로 되돌리려고 하면 실패한다")
    void revertToInTransit_Fail(DeliveryStatus status) {
        Delivery delivery = new Delivery(1L, 1L, status);
        assertThrows(IllegalStateException.class, delivery::revertToInTransit);
    }

    @Test
    @DisplayName("DELIVERED 상태일 때 FAILED 상태로 변경하려고 하면 실패한다")
    void fail_Fail() {
        Delivery delivery = new Delivery(1L, 1L, DeliveryStatus.DELIVERED);
        assertThrows(IllegalStateException.class, delivery::fail);
    }

    @ParameterizedTest
    @EnumSource(value = DeliveryStatus.class, names = {"IN_TRANSIT", "DELIVERED"})
    @DisplayName("배송이 시작되었거나 완료된 건을 취소하려고 하면 실패한다")
    void cancel_Fail(DeliveryStatus status) {
        Delivery delivery = new Delivery(1L, 1L, status);
        assertThrows(IllegalStateException.class, delivery::cancel);
    }
}
