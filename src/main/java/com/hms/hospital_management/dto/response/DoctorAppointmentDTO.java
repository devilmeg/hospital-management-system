package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAppointmentDTO {

    private String patientName;
    private Integer roomNumber;
    private String appointmentTime;
}
