package com.boostware.customauthservice.controller;

import com.boostware.customauthservice.dto.AuthRequest;
import com.boostware.customauthservice.service.AuthenticationService;
import com.boostware.customauthservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;
    private  final AuthenticationService authService;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }
}
