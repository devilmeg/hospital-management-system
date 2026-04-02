package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPatientDTO {
    private Integer patientSSN;
    private String patientName;
}
