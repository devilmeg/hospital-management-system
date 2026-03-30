package com.hms.hospital_management.constants;

public final class ErrorMessages {

    private ErrorMessages() {}

    // Generic
    public static final String INTERNAL_SERVER_ERROR = "Something went wrong. Please try again.";
    public static final String INVALID_REQUEST = "Invalid request data.";

    // Auth
    public static final String INVALID_CREDENTIALS = "Invalid username or password.";
    public static final String UNAUTHORIZED = "You are not authorized to access this resource.";
    public static final String FORBIDDEN = "Access denied.";

    // User
    public static final String USER_NOT_FOUND = "User not found.";

    // Patient
    public static final String PATIENT_NOT_FOUND = "Patient not found.";

    // Physician
    public static final String PHYSICIAN_NOT_FOUND = "Physician not found.";

    // Appointment
    public static final String APPOINTMENT_NOT_FOUND = "Appointment not found.";
    public static final String INVALID_APPOINTMENT_TIME = "Invalid appointment time.";

    // Validation
    public static final String VALIDATION_FAILED = "Validation failed.";

}