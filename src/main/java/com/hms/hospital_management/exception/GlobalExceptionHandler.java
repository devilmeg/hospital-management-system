package com.hms.hospital_management.exception;

import com.hms.hospital_management.constants.AppConstants;
import com.hms.hospital_management.constants.ErrorMessages;
import com.hms.hospital_management.dto.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404 - Resource Not Found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request
    ) {

        ErrorResponse error = new ErrorResponse();
        error.setApiPath(request.getRequestURI());
        error.setStatus(AppConstants.FAILED);
        error.setErrorMessage(ex.getMessage());
        error.setErrorTime(LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //  400 - Bad Request
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(
            BadRequestException ex,
            HttpServletRequest request
    ) {

        ErrorResponse error = new ErrorResponse();
        error.setApiPath(request.getRequestURI());
        error.setStatus(AppConstants.FAILED);
        error.setErrorMessage(ex.getMessage());
        error.setErrorTime(LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // 401 - Unauthorized
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorized(
            UnauthorizedException ex,
            HttpServletRequest request
    ) {

        ErrorResponse error = new ErrorResponse();
        error.setApiPath(request.getRequestURI());
        error.setStatus(AppConstants.FAILED);
        error.setErrorMessage(ex.getMessage());
        error.setErrorTime(LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    //  500 - Internal Server Error (fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
            Exception ex,
            HttpServletRequest request
    ) {

        ErrorResponse error = new ErrorResponse();
        error.setApiPath(request.getRequestURI());
        error.setStatus(AppConstants.FAILED);
        error.setErrorMessage(ErrorMessages.INTERNAL_SERVER_ERROR);
        error.setErrorTime(LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}