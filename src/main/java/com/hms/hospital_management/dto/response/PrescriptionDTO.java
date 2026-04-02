package com.hms.hospital_management.dto.response;

import lombok.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionDTO {

    private String medicationName;
    private String doctorName;
    private String dose;
    private Date prescribedDate;
}