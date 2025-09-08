package com.ko.playground.basic.api.parent;

import com.ko.playground.basic.api.parent.input.web.dto.RegisterParentRequest;
import com.ko.playground.basic.auth.LoginRequest;
import com.ko.playground.basic.core.parent.application.input.RegisterParent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parent")
@RequiredArgsConstructor
public class ParentAuthApi {
    
    private final RegisterParent registerParent;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterParentRequest request) {
        registerParent.register(request.toCommand(), passwordEncoder);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok().build();
    }
}
