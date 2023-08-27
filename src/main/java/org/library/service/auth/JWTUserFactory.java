package org.library.service.auth;


import org.library.model.entity.User;
import org.library.model.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

public final class JWTUserFactory {

    public static JWTUser create(User user) {
        return new JWTUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                List.of(new SimpleGrantedAuthority(user.getRole().name())));
    }

}
