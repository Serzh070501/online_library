package org.library.rest.controller;


import org.library.rest.auth.AuthRequest;
import org.library.rest.auth.AuthResponse;
import org.library.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authUser(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(new AuthResponse(authService.login(authRequest)));
    }
}
