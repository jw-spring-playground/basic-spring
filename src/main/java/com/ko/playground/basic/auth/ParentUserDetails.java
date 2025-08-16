package com.ko.playground.basic.auth;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class ParentUserDetails implements UserDetails {
    
    private final Long parentId;
    private final String email;
    private final String password;
    
    public ParentUserDetails(Long parentId, String email, String password) {
        this.parentId = parentId;
        this.email = email;
        this.password = password;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(Role.PARENT.getAuthority()));
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
