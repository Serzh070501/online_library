package org.library.service.auth.impl;//package org.library.service.impl;


import org.library.convertor.UserConverter;
import org.library.model.entity.User;
import org.library.service.UserService;
import org.library.service.auth.JWTUserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JWTUserDetailService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JWTUserDetailService.class);


    @Autowired
    UserService userService;

    @Autowired
    UserConverter userConverter;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userConverter.convertToEntity(userService.findByEmail(username));
        LOGGER.debug("IN loadUserByUsername  - user: with username: {} successfully loaded by ", username);
        return JWTUserFactory.create(user);
    }
}
