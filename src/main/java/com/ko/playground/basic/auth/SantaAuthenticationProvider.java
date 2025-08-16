package com.ko.playground.basic.auth;

import com.ko.playground.basic.core.santa.application.output.SantaRepository;
import com.ko.playground.basic.core.santa.domain.Santa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SantaAuthenticationProvider implements AuthenticationProvider {

    @Qualifier("santaUserDetailsService")
    private final UserDetailsService santaUserDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final SantaRepository santaRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = santaUserDetailsService.loadUserByUsername(email);
        
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        // Santa 엔티티를 다시 조회하여 AuthenticatedSanta 객체 생성
        Santa santa = santaRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Santa not found with email: " + email));
        
        AuthenticatedSanta authenticatedSanta = AuthenticatedSanta.of(
                santa.getId(),
                santa.getEmail(),
                Role.SANTA,
                santa.getDeliveryZoneId()
        );

        return new UsernamePasswordAuthenticationToken(
            authenticatedSanta,
            null,
            userDetails.getAuthorities()
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
