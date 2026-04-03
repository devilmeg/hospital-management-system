package com.hms.hospital_management.dto.response;

import lombok.*;

/**
 * Data transfer Object giving a simplified view of patient of a doctor
 * The DTO aggregates info of the Patient
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPatientDTO {
    /** Registered number of a particular patient*/
    private Integer patientSSN;
    /** Registered patient Name */
    private String patientName;
}
