package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorProcedureDTO {
    private String procedureName;
    private Double cost;
}
