package com.ko.playground.basic.auth;

import com.ko.playground.basic.core.santa.application.output.SantaRepository;
import com.ko.playground.basic.core.santa.domain.Santa;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("santaUserDetailsService")
@RequiredArgsConstructor
public class SantaUserDetailsService implements UserDetailsService {
    
    private final SantaRepository santaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Santa santa = santaRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Santa not found with email: " + email));

        return new SantaUserDetails(
                santa.getId(), 
                santa.getEmail(), 
                santa.getEncryptedPassword(),
                santa.getDeliveryZoneId()
        );
    }
}
