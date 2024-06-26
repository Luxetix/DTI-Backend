package com.luxetix.eventManagementWebsite.auth.service;

import org.springframework.security.core.Authentication;

public interface AuthService {
    String generateToken(Authentication authentication);

    void logout();
}
