package com.hms.hospital_management.dto.response;



import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String apiPath;        // from ApiPaths
    private String status;         // from constants (e.g., FAILED)
    private String errorMessage;   // from ErrorMessages
    private LocalDateTime errorTime;
}