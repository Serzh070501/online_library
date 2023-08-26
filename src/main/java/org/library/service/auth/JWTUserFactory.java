package org.library.service.auth;


import org.library.model.entity.User;
import org.library.model.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class JWTUserFactory {

    public static JWTUser create(User user) {
        return new JWTUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                mapToGrandAuthorities(user.getRoles()));
    }

    private static List<GrantedAuthority> mapToGrandAuthorities(Set<Role> roles) {
        return roles.stream()
                .map(o -> new SimpleGrantedAuthority(o.name()))
                .collect(Collectors.toList());
    }
}
