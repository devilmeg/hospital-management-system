package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentByDateDTO {

    private Integer appointmentId;
    private String patientName;
    private String doctorName;
}
