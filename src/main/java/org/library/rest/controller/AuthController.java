package org.library.rest.controller;


import org.library.rest.dto.UserDTO;
import org.library.rest.request.AuthRequest;
import org.library.rest.response.AuthResponse;
import org.library.service.UserService;
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
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authUser(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(new AuthResponse(authService.login(authRequest)));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userdto) {
        return ResponseEntity.ok((userService.register(userdto)));
    }
}
