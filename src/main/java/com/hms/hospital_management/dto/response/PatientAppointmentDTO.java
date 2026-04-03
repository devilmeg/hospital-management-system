package com.hms.hospital_management.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientAppointmentDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String physicianName;
    private String status;


}