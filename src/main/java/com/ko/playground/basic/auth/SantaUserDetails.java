package com.ko.playground.basic.auth;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class SantaUserDetails implements UserDetails {

    private final Long santaId;
    private final String email;
    private final String password;
    private final Long deliveryZoneId;
    
    public SantaUserDetails(Long santaId, String email, String password, Long deliveryZoneId) {
        this.santaId = santaId;
        this.email = email;
        this.password = password;
        this.deliveryZoneId = deliveryZoneId;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(Role.SANTA.getAuthority()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
