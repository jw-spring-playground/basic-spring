package com.ko.playground.basic.core.delivery.domain;

import com.ko.playground.basic.support.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity(name = "delivery")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;

    @Column(name = "delivery_zone_id")
    private Long deliveryZoneId;

    @Column(name = "santa_id")
    private Long santaId;

    @Column(name = "children_id", nullable = false)
    private Long childrenId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Delivery(Long childrenId, Long deliveryZoneId) {
        this.childrenId = childrenId;
        this.deliveryZoneId = deliveryZoneId;
        this.status = DeliveryStatus.PREPARING;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 테스트용 생성자
     */
    Delivery(Long childrenId, Long deliveryZoneId, DeliveryStatus status) {
        this.childrenId = childrenId;
        this.deliveryZoneId = deliveryZoneId;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // === 비즈니스 로직 (상태 변경) ===

    public void readyForDispatch() {
        if (this.status != DeliveryStatus.PREPARING) {
            throw new IllegalStateException("배송 준비중인 상태에서만 배송 준비 완료로 변경할 수 있습니다.");
        }
        this.status = DeliveryStatus.READY_FOR_DISPATCH;
        this.updatedAt = LocalDateTime.now();
    }

    public void startTransit(Long santaId) {
        if (this.status != DeliveryStatus.READY_FOR_DISPATCH) {
            throw new IllegalStateException("배송 준비 완료 상태에서만 배송을 시작할 수 있습니다.");
        }
        this.santaId = santaId;
        this.status = DeliveryStatus.IN_TRANSIT;
        this.updatedAt = LocalDateTime.now();
    }

    public void complete() {
        if (this.status != DeliveryStatus.IN_TRANSIT) {
            throw new IllegalStateException("배송중인 상태에서만 배송 완료로 변경할 수 있습니다.");
        }
        this.status = DeliveryStatus.DELIVERED;
        this.updatedAt = LocalDateTime.now();
    }

    public void fail() {
        if (this.status == DeliveryStatus.DELIVERED) {
            throw new IllegalStateException("이미 배송 완료된 건은 실패 처리할 수 없습니다.");
        }
        this.status = DeliveryStatus.FAILED;
        this.updatedAt = LocalDateTime.now();
    }

    public void cancel() {
        if (this.status == DeliveryStatus.IN_TRANSIT || this.status == DeliveryStatus.DELIVERED) {
            throw new IllegalStateException("이미 배송이 시작되었거나 완료된 건은 취소할 수 없습니다.");
        }
        this.status = DeliveryStatus.CANCELED;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 배송 완료 상태를 배송 중 상태로 되돌립니다. (실수 정정용)
     */
    public void revertToInTransit() {
        if (this.status != DeliveryStatus.DELIVERED) {
            throw new IllegalStateException("배송 완료 상태에서만 배송 중으로 되돌릴 수 있습니다.");
        }
        this.status = DeliveryStatus.IN_TRANSIT;
        this.updatedAt = LocalDateTime.now();
    }
}
