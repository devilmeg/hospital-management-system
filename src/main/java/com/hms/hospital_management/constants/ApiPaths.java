package com.hms.hospital_management.constants;

public final class ApiPaths {

    private ApiPaths() {}

    // Base
    public static final String API_BASE = "/api";
    public static final String VERSION_V1 = "/v1";

    // Full Base Path
    public static final String V1_BASE = API_BASE + VERSION_V1;

    // Auth
    public static final String AUTH = V1_BASE + "/auth";
    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";

    // Patient
    public static final String PATIENTS = V1_BASE + "/patients";

    // Physician
    public static final String PHYSICIANS = V1_BASE + "/physicians";

    // Appointment
    public static final String APPOINTMENTS = V1_BASE + "/appointments";

    // Admin
    public static final String ADMIN = V1_BASE + "/admin";

}