package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    private Integer appointmentId;
    private String doctorName;
    private String appointmentTime;
}
