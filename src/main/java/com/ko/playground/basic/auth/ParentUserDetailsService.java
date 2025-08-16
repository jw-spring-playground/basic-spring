package com.ko.playground.basic.auth;

import com.ko.playground.basic.core.parent.application.output.ParentRepository;
import com.ko.playground.basic.core.parent.domain.Parent;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("parentUserDetailsService")
@RequiredArgsConstructor
public class ParentUserDetailsService implements UserDetailsService {
    
    private final ParentRepository parentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Parent parent = parentRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Parent not found with email: " + email));

        return new ParentUserDetails(parent.getId(), parent.getEmail(), parent.getEncryptedPassword());
    }
}
