package com.ko.playground.basic.auth;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 인증된 부모 사용자의 정보를 담는 데이터 클래스
 */
@Getter
@Builder
public class AuthenticatedParent {
    private final Long parentId;
    private final String email;
    private final Role role;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    
    public static AuthenticatedParent of(Long parentId, String email, Role role) {
        return AuthenticatedParent.builder()
                .parentId(parentId)
                .email(email)
                .role(role)
                .build();
    }
}
