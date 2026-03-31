package com.hms.hospital_management.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequestDTO {

    private Integer appointmentId;
    private String doctorName;
    private String appointmentTime;
}