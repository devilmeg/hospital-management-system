package com.hms.hospital_management.constants;

public final class SecurityConstants {

    private SecurityConstants() {}

    // JWT
    public static final String JWT_SECRET = "your-super-secure-secret-key"; // 🔴 move to env later
    public static final long JWT_EXPIRATION = 86400000; // 1 day

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    // Roles
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_PHYSICIAN = "PHYSICIAN";
    public static final String ROLE_NURSE = "NURSE";
    public static final String ROLE_PATIENT = "PATIENT";

    // Public endpoints
    public static final String[] PUBLIC_URLS = {
            "/api/v1/auth/**",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    };
}