package com.hms.hospital_management.exception;

import com.hms.hospital_management.constants.AppConstants;
import com.hms.hospital_management.dto.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Resource Not Found (404)
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request
    ) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND, request);
    }

    /**
     * Bad Request (400)
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(
            BadRequestException ex,
            HttpServletRequest request
    ) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * Unauthorized (401)
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorized(
            UnauthorizedException ex,
            HttpServletRequest request
    ) {
        return buildResponse(ex.getMessage(), HttpStatus.UNAUTHORIZED, request);
    }

    /**
     * Forbidden (403)
     */
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorResponse> handleForbidden(
            ForbiddenException ex,
            HttpServletRequest request
    ) {
        return buildResponse(ex.getMessage(), HttpStatus.FORBIDDEN, request);
    }

    /**
     * Generic Exception (500)
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobal(
            Exception ex,
            HttpServletRequest request
    ) {
        return buildResponse(
                AppConstants.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }

    /**
     * Common Builder Method (DRY)
     */
    private ResponseEntity<ErrorResponse> buildResponse(
            String message,
            HttpStatus status,
            HttpServletRequest request
    ) {
        ErrorResponse error = ErrorResponse.builder()
                .apiPath(request.getRequestURI())
                .status(status.toString())
                .errorMessage(message)
                .errorTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, status);
    }
}
