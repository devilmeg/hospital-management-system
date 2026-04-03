package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDTO {

    private String medicationName;
    private String doctorName;
    private String dose;
    private String prescribedDate;
}
