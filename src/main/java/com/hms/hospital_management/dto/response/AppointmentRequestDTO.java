package com.hms.hospital_management.dto.response;


import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentRequestDTO {

    private Integer patientId;
    private Integer physicianId;
    private Integer nurseId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String room;
}