package org.library.service.auth;

import org.library.rest.auth.AuthRequest;

public interface AuthService {

    String login(AuthRequest authRequest);
}
