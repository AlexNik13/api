package com.example.api.security.jwt;

import com.example.api.model.User;
import com.example.api.repository.UserRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetails  implements UserDetailsService {

    private final UserRepositoryImpl userRepository;

    public JwtUserDetails(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        final User user = userRepository.getUserByEmail (email);

        if (user == null) {
            throw new UsernameNotFoundException("User '" + email + "' not found");
        }



        return org.springframework.security.core.userdetails.User//
                .withUsername(user.getName())//
                .password(user.getPassword())//
                .authorities(user.getRole().toString())//
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build();
    }
}
