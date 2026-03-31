package com.hms.hospital_management.constants;

public final class ApiPaths {

    private ApiPaths() {}


    public static final String API_BASE = "/api";
    public static final String VERSION_V1 = "/v1";
    public static final String V1_BASE = API_BASE + VERSION_V1;


    public static final String AUTH = V1_BASE + "/auth";
    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";


    public static final String PATIENTS = V1_BASE + "/patients";
    public static final String PATIENT_PRESCRIPTIONS = "/{ssn}/prescriptions";
    public static final String PATIENT_APPOINTMENTS = "/{ssn}/appointments";


    public static final String PHYSICIANS = V1_BASE + "/doctors"; // FIX naming
    public static final String DOCTOR_PATIENTS = "/{id}/patients";
    public static final String DOCTOR_APPOINTMENTS_TODAY = "/{id}/appointments/today";
    public static final String DOCTOR_PROCEDURES = "/{id}/procedures/trained";


    public static final String ROOMS = V1_BASE + "/rooms";
    public static final String ROOM_STATUS = "/status";

    public static final String APPOINTMENTS = V1_BASE + "/appointments";
    public static final String APPOINTMENTS_BY_DATE = "/date/{date}";

    public static final String NURSES = V1_BASE + "/nurses";
    public static final String NURSES_ON_CALL = "/on-call";


    public static final String ADMIN = V1_BASE + "/admin";
    public static final String REPORTS = "/reports";
    public static final String REVENUE = "/revenue";
    public static final String STAFF = "/staff";
    public static final String STAFF_ALL = "/all";
}