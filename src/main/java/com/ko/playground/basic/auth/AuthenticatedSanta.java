package com.ko.playground.basic.auth;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 인증된 산타 사용자의 정보를 담는 데이터 클래스
 */
@Getter
@Builder
public class AuthenticatedSanta {
    private final Long santaId;
    private final String email;
    private final Role role;
    private final Long deliveryZoneId;
    
    public static AuthenticatedSanta of(Long santaId, String email, Role role, Long deliveryZoneId) {
        return AuthenticatedSanta.builder()
                .santaId(santaId)
                .email(email)
                .role(role)
                .deliveryZoneId(deliveryZoneId)
                .build();
    }
}
