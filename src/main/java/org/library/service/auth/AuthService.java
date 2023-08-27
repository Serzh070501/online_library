package org.library.service.auth;

import org.library.rest.request.AuthRequest;

public interface AuthService {

    String login(AuthRequest authRequest);
}
