package com.ko.playground.basic.auth;

import com.ko.playground.basic.core.parent.application.output.ParentRepository;
import com.ko.playground.basic.core.parent.domain.Parent;
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
public class ParentAuthenticationProvider implements AuthenticationProvider {

    @Qualifier("parentUserDetailsService")
    private final UserDetailsService parentUserDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final ParentRepository parentRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = parentUserDetailsService.loadUserByUsername(email);
        
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        // Parent 엔티티를 다시 조회하여 AuthenticatedParent 객체 생성
        Parent parent = parentRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Parent not found with email: " + email));
        
        AuthenticatedParent authenticatedParent = AuthenticatedParent.of(
                parent.getId(),
                parent.getEmail(),
                Role.PARENT
        );

        return new UsernamePasswordAuthenticationToken(
            authenticatedParent,
            null,
            userDetails.getAuthorities()
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
