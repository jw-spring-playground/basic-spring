package com.ko.playground.basic.api.santa;

import com.ko.playground.basic.api.santa.adapter.input.web.dto.RegisterSantaRequest;
import com.ko.playground.basic.auth.LoginRequest;
import com.ko.playground.basic.core.santa.application.input.RegisterSanta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/santa")
@RequiredArgsConstructor
public class SantaAuthApi {
    
    private final RegisterSanta registerSanta;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterSantaRequest request) {
        registerSanta.register(request.toCommand(), passwordEncoder);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok().build();
    }
}
