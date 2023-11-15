package com.boostware.customauthservice.service;

import com.boostware.customauthservice.dto.AuthRequest;
import com.boostware.customauthservice.dto.RegisterRequest;
import com.boostware.customauthservice.model.Role;
import com.boostware.customauthservice.model.User;
import com.boostware.customauthservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private  final AuthenticationManager authenticationManager;

    public String register(RegisterRequest request) {
        User user = User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        return jwtService.generateToken(user);
    }

    public String authenticate(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        if (authentication.isAuthenticated()) {
            User user = userRepository.findByEmail(request.username()).orElseThrow();
            return jwtService.generateToken(user);
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }

    }
}
