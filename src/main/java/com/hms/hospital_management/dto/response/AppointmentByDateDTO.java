package com.hms.hospital_management.dto.response;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.hms.hospital_management.constants.AppConstants;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentByDateDTO {

    private String patientName;
    private String physicianName;
    private String examinationRoom;

    @JsonFormat(pattern = AppConstants.DATE_TIME_FORMAT)
    private LocalDateTime appointmentTime;
}