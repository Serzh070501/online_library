package org.library.service.auth.impl;


import lombok.RequiredArgsConstructor;
import org.library.config.security.JWTTokenProvider;
import org.library.convertor.UserConverter;
import org.library.rest.dto.UserDTO;
import org.library.rest.request.AuthRequest;
import org.library.service.UserService;
import org.library.service.auth.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final JWTTokenProvider tokenProvider;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserConverter userConverter;

    @Override
    public String login(AuthRequest authRequest) {
        logger.info("Logging in user for provided request - {}", authRequest);

        UserDTO byEmail = userService.findByEmail(authRequest.getUsername());

        if (!passwordEncoder.matches(authRequest.getPassword(), byEmail.getPassword())) {
            return "";
        }

        String authResponse = tokenProvider.createToken(userConverter.convertToEntity(byEmail));

        logger.info("Successfully logged in user for provided request - {}, response - {}", authRequest , authResponse);
        return authResponse;
    }
}
