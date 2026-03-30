package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRequestDTO {

    private String name;
    private String address;
    private String phone;
    private Integer insuranceId;
    private Integer primaryPhysicianId;
}