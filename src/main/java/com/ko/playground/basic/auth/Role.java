package com.ko.playground.basic.auth;

import lombok.Getter;

@Getter
public enum Role {
    SANTA("ROLE_SANTA"),
    PARENT("ROLE_PARENT");

    private final String authority;

    Role(String authority) {
        this.authority = authority;
    }

}
