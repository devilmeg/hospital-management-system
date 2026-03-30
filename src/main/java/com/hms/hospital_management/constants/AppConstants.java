package com.hms.hospital_management.constants;

public final class AppConstants {

    private AppConstants() {}


    //  APPLICATION INFO

    public static final String APP_NAME = "Hospital Management System";


    //  API STATUS

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";


    //  PAGINATION DEFAULTS

    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_SIZE = 10;
    public static final String DEFAULT_SORT_BY = "id";
    public static final String DEFAULT_SORT_DIR = "asc";


    //  DATE & TIME FORMAT

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";


    //  SECURITY HEADERS (JWT READY)

    public static final String AUTH_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";


    //  ERROR MESSAGES (GLOBAL FALLBACK)

    public static final String INTERNAL_SERVER_ERROR =
            "Something went wrong. Please try again later.";

    public static final String INVALID_REQUEST =
            "Invalid request data.";

    public static final String ACCESS_DENIED =
            "You do not have permission to access this resource.";

    public static final String UNAUTHORIZED =
            "Authentication required.";


    //  COMMON RESPONSE MESSAGES

    public static final String DATA_FETCHED = "Data fetched successfully";
    public static final String DATA_CREATED = "Data created successfully";
    public static final String DATA_UPDATED = "Data updated successfully";
    public static final String DATA_DELETED = "Data deleted successfully";


    //  LOGGING (OPTIONAL)

    public static final String LOG_REQUEST = "Incoming Request: ";
    public static final String LOG_RESPONSE = "Outgoing Response: ";
}