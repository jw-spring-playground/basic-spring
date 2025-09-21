package com.ko.playground.basic.core.delivery.domain;

import java.util.List;

/**
 * 배달의 상태
 */
public enum DeliveryStatus {
    /**
     * 배달 준비중.
     * 주문이 접수되어 상품 포장 및 배송을 준비하는 단계
     */
    PREPARING,

    /**
     * 배송 준비 완료.
     * 상품 준비가 완료되어 산타 배정을 기다리는 단계
     */
    READY_FOR_DISPATCH,

    /**
     * 배송중.
     * 산타가 배정되어 고객에게 상품을 전달하고 있는 단계
     */
    IN_TRANSIT,

    /**
     * 배송 완료.
     * 상품이 고객에게 성공적으로 전달된 단계
     */
    DELIVERED,

    /**
     * 배송 실패.
     * 주소 불명, 수취인 부재 등의 사유로 배송에 실패한 단계
     */
    FAILED,

    /**
     * 배달 취소.
     * 어떠한 사유로든 배달이 취소된 단계
     */
    CANCELED
}
