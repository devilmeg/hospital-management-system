package com.hms.hospital_management.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hms.hospital_management.constants.AppConstants;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAppointmentDTO {

    private String patientName;
    private String room;

    @JsonFormat(pattern = AppConstants.DATE_TIME_FORMAT)
    private LocalDateTime appointmentTime;
}
